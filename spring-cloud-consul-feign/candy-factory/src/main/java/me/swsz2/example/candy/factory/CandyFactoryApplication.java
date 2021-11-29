package me.swsz2.example.candy.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CandyFactoryApplication {

  public static void main(String[] args) {
    SpringApplication.run(CandyFactoryApplication.class, args);
  }
}
