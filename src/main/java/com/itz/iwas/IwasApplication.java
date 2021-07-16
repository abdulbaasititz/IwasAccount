package com.itz.iwas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class IwasApplication {
    @Value("${spring.date.time.zone}")
    private String timeZone;

    public static void main(String[] args) {
        SpringApplication.run(IwasApplication.class, args);
    }

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
    }

}
