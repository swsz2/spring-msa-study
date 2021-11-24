package me.swsz.cloud.bookfactory.component;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/** Created by sungwonkim on 2021-11-24 */
@FeignClient("book-factory")
public interface FeignClientSample {
  @GetMapping(value = "/ping")
  String ping();
}
