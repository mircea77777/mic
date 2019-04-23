package com.softvision.mircea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class AppExample {

    public static void main(String[] args) {
        SpringApplication.run(AppExample.class, args);
    }

}
