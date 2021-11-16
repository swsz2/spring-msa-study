package me.swsz.cloud.bookdanawa.contoller.handler;

import lombok.extern.slf4j.Slf4j;
import me.swsz.cloud.bookdanawa.exception.BookAndBookStoreNotFoundException;
import me.swsz.cloud.bookdanawa.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/** Created by sungwonkim on 2021-11-16 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler(BookAndBookStoreNotFoundException.class)
  public ExceptionResponse bookNotFoundExceptionHandler(
      final HttpServletRequest httpServletRequest,
      final BookAndBookStoreNotFoundException bookAndBookStoreNotFoundException) {

    return ExceptionResponse.builder()
        .message(bookAndBookStoreNotFoundException.getMessage())
        .address(httpServletRequest.getRemoteAddr())
        .method(httpServletRequest.getMethod())
        .path(httpServletRequest.getRequestURI())
        .build();
  }
}
