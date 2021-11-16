package me.swsz2.cloud.gateway.contoller.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.swsz2.cloud.gateway.model.ExceptionResponse;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class GatewayExceptionHandler implements ErrorWebExceptionHandler {

  private final ObjectMapper objectMapper;

  @Override
  public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {

    final ServerHttpResponse response = serverWebExchange.getResponse();
    final ServerHttpRequest request = serverWebExchange.getRequest();

    // when response was already committed, throw throwable object
    if (response.isCommitted()) {
      return Mono.error(throwable);
    }

    // set header of response
    response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

    // return exception response
    return response.writeWith(
        Mono.fromSupplier(
            () -> {
              DataBufferFactory bufferFactory = response.bufferFactory();
              try {
                return bufferFactory.wrap(
                    objectMapper.writeValueAsBytes(
                        ExceptionResponse.builder()
                            .message(throwable.getMessage())
                            .address(request.getRemoteAddress())
                            .method(request.getMethodValue())
                            .path(request.getURI())
                            .build()));
              } catch (JsonProcessingException jsonProcessingException) {
                log.error("Error writing response : {}", throwable.getMessage(), throwable);
                return bufferFactory.wrap(new byte[0]);
              }
            }));
  }
}
