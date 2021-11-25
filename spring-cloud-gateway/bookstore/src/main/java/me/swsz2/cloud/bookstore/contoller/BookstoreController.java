package me.swsz2.cloud.bookstore.contoller;

import lombok.RequiredArgsConstructor;
import me.swsz2.cloud.bookstore.exception.BookNotFoundException;
import me.swsz2.cloud.bookstore.model.Book;
import me.swsz2.cloud.bookstore.service.BookManageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookstoreController {

  private final BookManageService bookManageService;

  @GetMapping(value = "/api/v1/book/find")
  public Book find(@RequestParam(name = "title") final String title) throws BookNotFoundException {
    return bookManageService.findFirstByTitle(title);
  }
}
