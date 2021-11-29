package me.swsz2.example.candy.store.contoller;

import com.muhayu.example.candy.store.model.*;
import me.swsz2.example.candy.store.model.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** Created by sungwonkim on 2021-11-25 */
@RestController
public class CandyStoreController {

  private final CandyDisplayStand candyDisplayStand = new CandyDisplayStand();

  @PostMapping(value = "/api/v1/store/candy")
  public CandyDisplayStand storeCandy(@RequestBody final Candy candy) {
    candyDisplayStand.add(candy);
    return candyDisplayStand;
  }

  @PostMapping(value = "/api/v1/store/candies")
  public CandyDisplayStand storeCandies(@RequestBody final Candies candies) {
    candyDisplayStand.add(candies);
    return candyDisplayStand;
  }

  @PostMapping(value = "/api/v1/store/candy/box")
  public CandyDisplayStand storeCandyBox(@RequestBody final CandyBox candyBox) {
    candyDisplayStand.add(candyBox);
    return candyDisplayStand;
  }

  @PostMapping(value = "/api/v1/store/candy/boxes")
  public CandyDisplayStand storeCandyBoxes(@RequestBody final CandyBoxes candyBoxes) {
    candyDisplayStand.add(candyBoxes);
    return candyDisplayStand;
  }
}
