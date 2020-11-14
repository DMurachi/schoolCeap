package com.bucares.barcode;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class BardcodeApp {

    public static void main(String[] args) {
        SpringApplication.run(BardcodeApp.class, args);
    }

}

