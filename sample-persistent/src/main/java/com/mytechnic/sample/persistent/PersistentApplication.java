package com.mytechnic.sample.persistent;

import com.mytechnic.sample.RootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.02.19.
 */
@EnableTransactionManagement
@SpringBootApplication(scanBasePackageClasses = RootApplication.class)
public class PersistentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistentApplication.class, args);
	}
}
