package com.mytechnic.sample.core;

import com.mytechnic.sample.RootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
@SpringBootApplication(scanBasePackageClasses = RootApplication.class)
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }
}
