package me.swsz2.cloud.bookstore.exception;

/** Created by sungwonkim on 2021-11-16 */
public class BookNotFoundException extends Throwable {
  public BookNotFoundException(final String message) {
    super(message);
  }
}
