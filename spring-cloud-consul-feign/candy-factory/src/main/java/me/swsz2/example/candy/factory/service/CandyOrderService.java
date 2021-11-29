package me.swsz2.example.candy.factory.service;

import me.swsz2.example.candy.factory.component.CandyFactory;
import me.swsz2.example.candy.factory.model.Candies;
import me.swsz2.example.candy.factory.model.Candy;
import me.swsz2.example.candy.factory.model.CandyBox;
import me.swsz2.example.candy.factory.model.CandyBoxes;
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
