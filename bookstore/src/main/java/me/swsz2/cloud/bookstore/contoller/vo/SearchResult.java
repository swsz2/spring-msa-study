package me.swsz2.cloud.bookstore.contoller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult {
  private long id;
  private String title;
  private int amount;

  public static SearchResult dummy() {
    return new SearchResult(-1, "dummy book!", -1);
  }
}
