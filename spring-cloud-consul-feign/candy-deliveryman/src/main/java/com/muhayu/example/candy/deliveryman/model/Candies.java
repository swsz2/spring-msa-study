package com.muhayu.example.candy.deliveryman.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;

/** Created by sungwonkim on 2021-11-25 */
@Data
@NoArgsConstructor
public class Candies {
  private final ArrayList<Candy> candies = new ArrayList<>();

  public Candies(final Candy... candies) {
    this.candies.addAll(Arrays.asList(candies));
  }
}
