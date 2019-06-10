package net.turvo.rangeproblem.rangeproblem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RangeproblemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RangeproblemApplication.class, args);
    }

}
