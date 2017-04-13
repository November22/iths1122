package com.iths1122;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启声明式事务支持
public class Iths1122Application {

	public static void main(String[] args) {
		SpringApplication.run(Iths1122Application.class, args);
	}
}
