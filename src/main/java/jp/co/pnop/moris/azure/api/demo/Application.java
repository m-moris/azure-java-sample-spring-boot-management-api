package jp.co.pnop.moris.azure.api.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import groovy.util.logging.Slf4j;

@SpringBootApplication
@EnableAsync
@Slf4j
public class Application {
   
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}