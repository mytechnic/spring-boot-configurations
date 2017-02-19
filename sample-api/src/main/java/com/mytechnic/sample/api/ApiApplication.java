package com.mytechnic.sample.api;

import com.mytechnic.sample.RootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
@SpringBootApplication(scanBasePackageClasses = RootApplication.class)
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
