package me.swsz2.cloud.gateway.contoller.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class GatewayExceptionHandler implements ErrorWebExceptionHandler {

  private final ObjectMapper objectMapper;

  @Override
  public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
    ServerHttpResponse response = serverWebExchange.getResponse();

    if (response.isCommitted()) {
      return Mono.error(throwable);
    }

    // header set
    response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
    if (throwable instanceof ResponseStatusException) {
      response.setStatusCode(((ResponseStatusException) throwable).getStatus());
    }

    return response.writeWith(
        Mono.fromSupplier(
            () -> {
              DataBufferFactory bufferFactory = response.bufferFactory();
              try {
                return bufferFactory.wrap(objectMapper.writeValueAsBytes(throwable.getMessage()));
              } catch (JsonProcessingException e) {
                log.warn("Error writing response", throwable);
                return bufferFactory.wrap(new byte[0]);
              }
            }));
  }
}
