package me.swsz.cloud.bookfactory.cotroller;

import lombok.RequiredArgsConstructor;
import me.swsz.cloud.bookfactory.component.FeignClientSample;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/** Created by sungwonkim on 2021-11-24 */
@RestController
@RequiredArgsConstructor
public class BookFactoryController {

  private final DiscoveryClient discoveryClient;
  private final FeignClientSample feignClientSample;

  @EventListener(ApplicationReadyEvent.class)
  public void findByServiceName() {
    System.out.println("feignClientSample.ping() = " + feignClientSample.ping());
  }

  @GetMapping(value = "/ping")
  @ResponseBody
  public String ping() {
    return "pong";
  }
}
