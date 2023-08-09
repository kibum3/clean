package com.mom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.mom.admin.mapper.*")
public class MomsCleanApplication {

	public static void main(String[] args) {
		SpringApplication.run(MomsCleanApplication.class, args);
	}

}