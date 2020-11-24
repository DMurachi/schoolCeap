package com.bucares.barcode;

import com.bucares.barcode.repository.EstudianteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
@EnableJpaRepositories(basePackages="com.bucares.barcode")
@SpringBootApplication
public class BardcodeApp {
    public static void main(String[] args) {
        SpringApplication.run(BardcodeApp.class, args);
    }
}

