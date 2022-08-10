package com.op.surgerymis;

import org.apache.tomcat.jni.Time;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.util.TimeZone;

@SpringBootApplication
public class SurgerymisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurgerymisApplication.class, args);
        System.out.println("Hello Channy");
    }

}
