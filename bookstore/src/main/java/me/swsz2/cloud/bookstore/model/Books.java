package me.swsz2.cloud.bookstore.model;

import me.swsz2.cloud.bookstore.exception.BookNotFoundException;

import java.util.List;

/** Created by sungwonkim on 2021-11-16 */
public class Books {

  private final List<Book> books;

  public Books(final List<Book> books) {
    this.books = books;
  }

  /**
   * @param title title
   * @return book
   * @throws BookNotFoundException : when books not contains book, that has equal title
   */
  public Book findFirstByTitle(final String title) throws BookNotFoundException {
    return books.stream()
        .filter(book -> book.getTitle().equalsIgnoreCase(title))
        .findFirst()
        .orElseThrow(() -> new BookNotFoundException("not found book (" + title + ")."));
  }
}
