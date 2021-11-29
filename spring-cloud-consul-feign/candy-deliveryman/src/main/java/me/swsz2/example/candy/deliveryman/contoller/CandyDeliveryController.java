package me.swsz2.example.candy.deliveryman.contoller;

import me.swsz2.example.candy.deliveryman.client.CandyFactoryClient;
import me.swsz2.example.candy.deliveryman.client.CandyStoreClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.swsz2.example.candy.deliveryman.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** Created by sungwonkim on 2021-11-25 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class CandyDeliveryController {

  private final CandyFactoryClient candyFactoryClient;
  private final CandyStoreClient candyStoreClient;

  @GetMapping(value = "/api/v1/deliver/candy")
  public CandyDisplayStand deliverCandy() {
    final Candy candy = candyFactoryClient.orderCandy();
    log.info("[{}]", candy);
    return candyStoreClient.storeCandy(candy);
  }

  @GetMapping(value = "/api/v1/deliver/candies")
  public CandyDisplayStand deliverCandies() {
    final Candies candies = candyFactoryClient.orderCandies();
    log.info("[{}]", candies);
    return candyStoreClient.storeCandies(candies);
  }

  @GetMapping(value = "/api/v1/deliver/candy/box")
  public CandyDisplayStand deliverCandyBox() {
    final CandyBox candyBox = candyFactoryClient.orderCandyBox();
    log.info("[{}]", candyBox);
    return candyStoreClient.storeCandyBox(candyBox);
  }

  @GetMapping(value = "/api/v1/deliver/candy/boxes")
  public CandyDisplayStand deliverCandyBoxes() {
    final CandyBoxes candyBoxes = candyFactoryClient.orderCandyBoxes();
    log.info("[{}]", candyBoxes);
    return candyStoreClient.storeCandyBoxes(candyBoxes);
  }
}
