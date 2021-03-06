package me.swsz2.example.candy.deliveryman.client;

import me.swsz2.example.candy.deliveryman.model.Candies;
import me.swsz2.example.candy.deliveryman.model.Candy;
import me.swsz2.example.candy.deliveryman.model.CandyBox;
import me.swsz2.example.candy.deliveryman.model.CandyBoxes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/** Created by sungwonkim on 2021-11-25 */
@FeignClient("candy-factory")
public interface CandyFactoryClient {
  @GetMapping(value = "/api/v1/order/candy")
  Candy orderCandy();

  @GetMapping(value = "/api/v1/order/candies")
  Candies orderCandies();

  @GetMapping(value = "/api/v1/order/candy/box")
  CandyBox orderCandyBox();

  @GetMapping(value = "/api/v1/order/candy/boxes")
  CandyBoxes orderCandyBoxes();
}
