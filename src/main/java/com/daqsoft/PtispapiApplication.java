package com.daqsoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAsync
@MapperScan("com.daqsoft.mapper")
public class PtispapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtispapiApplication.class, args);
	}
}
