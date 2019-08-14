package com.qingzhai.plate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @author accompany
 * @date 2018/05/14
 */
@SpringBootApplication
public class PlateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlateApplication.class, args);
	}

	@Bean
	public IdWorker idWorker(){
		return new IdWorker(1, 1);
	}
	
}
