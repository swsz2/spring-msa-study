package me.swsz2.cloud.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Created by sungwonkim on 2021-11-16 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
  private long id;
  private String title;
  private long price;
  private int amount;
}
