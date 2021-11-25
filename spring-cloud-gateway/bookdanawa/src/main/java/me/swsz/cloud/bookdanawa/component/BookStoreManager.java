package me.swsz.cloud.bookdanawa.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.swsz.cloud.bookdanawa.exception.BookAndBookStoreNotFoundException;
import me.swsz.cloud.bookdanawa.model.Book;
import me.swsz.cloud.bookdanawa.model.BookAndBookStore;
import me.swsz.cloud.bookdanawa.model.BookStore;
import me.swsz.cloud.bookdanawa.model.BookStores;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/** Created by sungwonkim on 2021-11-16 */
@Slf4j
@Component
@RequiredArgsConstructor
public class BookStoreManager {

  private final BookStores bookStores;
  private final RestTemplate restTemplate;

  public BookStoreManager() {
    this.bookStores = new BookStores(Arrays.asList(new BookStore("김성원 책방", "경기도 안산")));
    this.restTemplate = new RestTemplate();
  }

  public BookAndBookStore findBookAndBookStoreByTitle(final String title)
      throws BookAndBookStoreNotFoundException {
    for (final BookStore bookStore : bookStores.getBookStores()) {
      try {
        final Book book =
            restTemplate.getForObject(
                String.format("%s?%s=%s", "http://localhost:8080/api/v1/book/find", "title", title),
                Book.class);
        return new BookAndBookStore(book, bookStore);
      } catch (Exception continuable) {
        // TODO: 2021-11-16 send to zipkin
        log.warn("[{}] {}", continuable.getMessage(), bookStore);
      }
    }
    throw new BookAndBookStoreNotFoundException("not found book (" + title + ").");
  }
}
