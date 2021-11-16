package me.swsz.cloud.bookdanawa.model;

import lombok.Getter;

import java.util.List;

/** Created by sungwonkim on 2021-11-16 */
@Getter
public class BookStores {
  private final List<BookStore> bookStores;

  public BookStores(final List<BookStore> bookStores) {
    this.bookStores = bookStores;
  }
}
