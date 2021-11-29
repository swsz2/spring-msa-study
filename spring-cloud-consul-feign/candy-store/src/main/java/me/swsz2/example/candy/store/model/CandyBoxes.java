package me.swsz2.example.candy.store.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;

/** Created by sungwonkim on 2021-11-25 */
@Data
@NoArgsConstructor
public class CandyBoxes {
  private final ArrayList<CandyBox> candyBoxes = new ArrayList<>();

  public CandyBoxes(final CandyBox... candyBoxes) {
    this.candyBoxes.addAll(Arrays.asList(candyBoxes));
  }
}
