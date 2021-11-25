package com.muhayu.example.candy.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CandyStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CandyStoreApplication.class, args);
    }

}
