package me.swsz2.cloud.bookstore.component;

import me.swsz2.cloud.bookstore.exception.BookNotFoundException;
import me.swsz2.cloud.bookstore.model.Book;
import me.swsz2.cloud.bookstore.model.Books;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/** Created by sungwonkim on 2021-11-16 */
@Component
public class BookWareHouse {

  private final Books books;

  public BookWareHouse() {
    // init and setup books
    this.books =
        new Books(
            Arrays.asList(
                new Book(1L, "EFFECTIVE JAVA", 1000L, 7),
                new Book(2L, "SPRING CLOUD GATEWAY", 2000L, 10),
                new Book(3L, "MICROSERVICE", 3000L, 5),
                new Book(4L, "GREEN TEA LATTE RECIPE", 4000L, 64)));
  }

  public Book findByTitle(final String title) throws BookNotFoundException {
    return books.findFirstByTitle(title);
  }
}
