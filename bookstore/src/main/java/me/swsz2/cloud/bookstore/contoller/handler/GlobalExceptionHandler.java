package me.swsz2.cloud.bookstore.contoller.handler;

import lombok.extern.slf4j.Slf4j;
import me.swsz2.cloud.bookstore.exception.BookNotFoundException;
import me.swsz2.cloud.bookstore.model.ExceptionResponse;
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
  @ExceptionHandler(BookNotFoundException.class)
  public ExceptionResponse bookNotFoundExceptionHandler(
      final HttpServletRequest httpServletRequest,
      final BookNotFoundException bookNotFoundException) {

    return ExceptionResponse.builder()
        .message(bookNotFoundException.getMessage())
        .address(httpServletRequest.getRemoteAddr())
        .method(httpServletRequest.getMethod())
        .path(httpServletRequest.getRequestURI())
        .build();
  }
}
