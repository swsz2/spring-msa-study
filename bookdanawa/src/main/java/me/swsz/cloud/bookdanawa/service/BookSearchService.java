package me.swsz.cloud.bookdanawa.service;

import lombok.RequiredArgsConstructor;
import me.swsz.cloud.bookdanawa.component.BookStoreManager;
import me.swsz.cloud.bookdanawa.exception.BookAndBookStoreNotFoundException;
import me.swsz.cloud.bookdanawa.model.BookAndBookStore;
import org.springframework.stereotype.Service;

/** Created by sungwonkim on 2021-11-16 */
@Service
@RequiredArgsConstructor
public class BookSearchService {

  private final BookStoreManager bookStoreManager;

  public BookAndBookStore searchBookAndBookStoreByTitle(final String title) throws BookAndBookStoreNotFoundException {
    return bookStoreManager.findBookAndBookStoreByTitle(title);
  }
}
