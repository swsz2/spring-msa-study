package com.muhayu.example.candy.factory.service;

import com.muhayu.example.candy.factory.component.CandyFactory;
import com.muhayu.example.candy.factory.model.Candies;
import com.muhayu.example.candy.factory.model.Candy;
import com.muhayu.example.candy.factory.model.CandyBox;
import com.muhayu.example.candy.factory.model.CandyBoxes;
import org.springframework.stereotype.Service;

/** Created by sungwonkim on 2021-11-25 */
@Service
public class CandyOrderService {

  public Candy orderColaCandy() {
    return CandyFactory.cookColaCandy();
  }

  public Candy orderMintCandy() {
    return CandyFactory.cookMintCandy();
  }

  public Candies orderColaCandies() {
    return new Candies(
        orderColaCandy(), orderColaCandy(), orderColaCandy(), orderColaCandy(), orderColaCandy());
  }

  public Candies orderMintCandies() {
    return new Candies(
        orderMintCandy(), orderMintCandy(), orderMintCandy(), orderMintCandy(), orderMintCandy());
  }

  public CandyBox orderColaCandyBox() {
    return new CandyBox(orderColaCandies(), orderColaCandies());
  }

  public CandyBox orderMintCandyBox() {
    return new CandyBox(orderMintCandies(), orderMintCandies());
  }

  public CandyBoxes orderColaCandyBoxes() {
    return new CandyBoxes(orderColaCandyBox(), orderColaCandyBox());
  }

  public CandyBoxes orderMintCandyBoxes() {
    return new CandyBoxes(orderMintCandyBox(), orderMintCandyBox());
  }
}
