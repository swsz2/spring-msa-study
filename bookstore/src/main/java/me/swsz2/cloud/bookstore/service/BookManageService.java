package me.swsz2.cloud.bookstore.service;

import lombok.RequiredArgsConstructor;
import me.swsz2.cloud.bookstore.component.BookWareHouse;
import me.swsz2.cloud.bookstore.exception.BookNotFoundException;
import me.swsz2.cloud.bookstore.model.Book;
import org.springframework.stereotype.Service;

/** Created by sungwonkim on 2021-11-16 */
@Service
@RequiredArgsConstructor
public class BookManageService {

  private final BookWareHouse bookWareHouse;

  public Book findFirstByTitle(final String title) throws BookNotFoundException {
    return bookWareHouse.findByTitle(title);
  }
}
