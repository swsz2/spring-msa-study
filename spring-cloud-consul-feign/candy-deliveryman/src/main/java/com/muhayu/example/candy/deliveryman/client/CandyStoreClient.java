package com.muhayu.example.candy.deliveryman.client;

import com.muhayu.example.candy.deliveryman.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/** Created by sungwonkim on 2021-11-25 */
@FeignClient("candy-store")
public interface CandyStoreClient {

  @PostMapping(value = "/api/v1/store/candy")
  CandyDisplayStand storeCandy(@RequestBody final Candy candy);

  @PostMapping(value = "/api/v1/store/candies")
  CandyDisplayStand storeCandies(@RequestBody final Candies candies);

  @PostMapping(value = "/api/v1/store/candy/box")
  CandyDisplayStand storeCandyBox(@RequestBody final CandyBox candyBox);

  @PostMapping(value = "/api/v1/store/candy/boxes")
  CandyDisplayStand storeCandyBoxes(@RequestBody final CandyBoxes candyBoxes);
}
