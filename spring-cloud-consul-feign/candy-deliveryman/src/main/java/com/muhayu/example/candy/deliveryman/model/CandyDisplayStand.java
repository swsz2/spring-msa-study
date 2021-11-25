package com.muhayu.example.candy.deliveryman.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Data
@NoArgsConstructor
public class CandyDisplayStand {

  private final LinkedList<Candy> candies = new LinkedList<>();
  private final LinkedList<Candies> candiesPack = new LinkedList<>();
  private final LinkedList<CandyBox> candyBoxes = new LinkedList<>();
  private final LinkedList<CandyBoxes> candyBoxesPack = new LinkedList<>();

  public synchronized boolean add(final Candy candy) {
    return this.candies.add(candy);
  }

  public synchronized boolean add(final Candies candies) {
    return this.candiesPack.add(candies);
  }

  public synchronized boolean add(final CandyBox candyBox) {
    return this.candyBoxes.add(candyBox);
  }

  public synchronized boolean add(final CandyBoxes candyBoxes) {
    return this.candyBoxesPack.add(candyBoxes);
  }
}
