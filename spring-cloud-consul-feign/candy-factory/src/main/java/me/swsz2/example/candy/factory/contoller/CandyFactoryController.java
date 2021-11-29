package me.swsz2.example.candy.factory.contoller;

import me.swsz2.example.candy.factory.model.Candies;
import me.swsz2.example.candy.factory.model.Candy;
import me.swsz2.example.candy.factory.model.CandyBox;
import me.swsz2.example.candy.factory.model.CandyBoxes;
import me.swsz2.example.candy.factory.service.CandyOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** Created by sungwonkim on 2021-11-25 */
@RestController
@RequiredArgsConstructor
public class CandyFactoryController {

  private final CandyOrderService candyOrderService;

  @GetMapping(value = "/api/v1/order/candy")
  public Candy orderCandy() {
    return ((int) (Math.random() * 10) % 2 == 0)
        ? candyOrderService.orderColaCandy()
        : candyOrderService.orderMintCandy();
  }

  @GetMapping(value = "/api/v1/order/candies")
  public Candies orderCandies() {
    return ((int) (Math.random() * 10) % 2 == 0)
        ? candyOrderService.orderColaCandies()
        : candyOrderService.orderMintCandies();
  }

  @GetMapping(value = "/api/v1/order/candy/box")
  public CandyBox orderCandyBox() {
    return ((int) (Math.random() * 10) % 2 == 0)
        ? candyOrderService.orderColaCandyBox()
        : candyOrderService.orderMintCandyBox();
  }

  @GetMapping(value = "/api/v1/order/candy/boxes")
  public CandyBoxes orderCandyBoxes() {
    return ((int) (Math.random() * 10) % 2 == 0)
        ? candyOrderService.orderColaCandyBoxes()
        : candyOrderService.orderMintCandyBoxes();
  }
}
