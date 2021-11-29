package me.swsz2.example.candy.store.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;

/** Created by sungwonkim on 2021-11-25 */
@Data
@NoArgsConstructor
public class CandyBox {
  private final ArrayList<Candies> candies = new ArrayList<>();

  public CandyBox(final Candies... candies) {
    this.candies.addAll(Arrays.asList(candies));
  }
}
