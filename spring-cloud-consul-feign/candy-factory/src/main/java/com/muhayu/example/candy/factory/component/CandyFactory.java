package com.muhayu.example.candy.factory.component;

import com.muhayu.example.candy.factory.model.Candy;

/** Created by sungwonkim on 2021-11-25 */
public class CandyFactory {

  public static final String COLA = "cola";
  public static final String MINT = "mint";

  public static Candy cookColaCandy() {
    return new Candy(COLA);
  }

  public static Candy cookMintCandy() {
    return new Candy(MINT);
  }
}
