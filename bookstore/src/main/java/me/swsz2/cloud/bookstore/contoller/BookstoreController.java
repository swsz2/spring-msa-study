package me.swsz2.cloud.bookstore.contoller;

import me.swsz2.cloud.bookstore.contoller.vo.SearchResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Random;

@RestController
public class BookstoreController {

  private final Random RANDOM = new Random();
  private final int MAX_ID = 10;
  private final int MIN_ID = 1;
  private final int MAX_AMOUNT = 10;

  @GetMapping(value = "/api/v1/search")
  public SearchResult search(@RequestParam(name = "title") final Optional<String> title) {
    return title
        .map(
            s ->
                new SearchResult(
                    RANDOM.nextInt(MAX_ID) + MIN_ID, s, RANDOM.nextInt(MAX_AMOUNT) + MIN_ID))
        .orElseGet(SearchResult::dummy);
  }
}
