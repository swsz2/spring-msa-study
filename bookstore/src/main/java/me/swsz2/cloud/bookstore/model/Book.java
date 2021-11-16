package me.swsz2.cloud.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/** Created by sungwonkim on 2021-11-16 */
@Data
@AllArgsConstructor
public class Book {
  private long id;
  private String title;
  private long price;
  private int amount;
}
