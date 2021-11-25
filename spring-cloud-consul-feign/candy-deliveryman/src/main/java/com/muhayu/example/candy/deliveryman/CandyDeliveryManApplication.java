package com.muhayu.example.candy.deliveryman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CandyDeliveryManApplication {

  public static void main(String[] args) {
    SpringApplication.run(CandyDeliveryManApplication.class, args);
  }
}
