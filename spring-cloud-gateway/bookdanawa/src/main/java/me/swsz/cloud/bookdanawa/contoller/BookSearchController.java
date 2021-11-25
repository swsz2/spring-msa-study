package me.swsz.cloud.bookdanawa.contoller;

import lombok.RequiredArgsConstructor;
import me.swsz.cloud.bookdanawa.exception.BookAndBookStoreNotFoundException;
import me.swsz.cloud.bookdanawa.model.BookAndBookStore;
import me.swsz.cloud.bookdanawa.service.BookSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** Created by sungwonkim on 2021-11-16 */
@RestController
@RequiredArgsConstructor
public class BookSearchController {

  private final BookSearchService bookSearchService;

  @GetMapping(value = "/api/v1/book/search")
  public BookAndBookStore searchBookAndBookStore(
      @RequestParam(name = "title") final String bookTitle) throws BookAndBookStoreNotFoundException {
      return bookSearchService.searchBookAndBookStoreByTitle(bookTitle);
  }
}
