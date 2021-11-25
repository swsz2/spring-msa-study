package me.swsz.cloud.bookdanawa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/** Created by sungwonkim on 2021-11-16 */
@Data
@AllArgsConstructor
public class BookAndBookStore {
  private Book book;
  private BookStore bookStore;
}
