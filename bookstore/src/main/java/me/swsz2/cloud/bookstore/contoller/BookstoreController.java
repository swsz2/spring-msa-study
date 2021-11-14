package me.swsz2.cloud.bookstore.contoller;

import me.swsz2.cloud.bookstore.contoller.vo.SearchResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BookstoreController {
  @GetMapping(value = "/api/v1/search")
  public SearchResult search(@RequestParam(name = "title") final Optional<String> title) {
    return title.map(s -> new SearchResult(1, s, 1)).orElseGet(SearchResult::dummy);
  }
}
