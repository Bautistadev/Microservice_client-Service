package com.Microservice.clientService;

import com.Microservice.clientService.Service.AddressService;
import com.Microservice.clientService.Service.ClientService;
import com.Microservice.clientService.Service.LocationService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
@ComponentScan(basePackages = {"com.Microservice.clientService"})
public class MainApplication implements CommandLineRunner {



	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(MainApplication.class);
		application.setApplicationStartup(new BufferingApplicationStartup(2048));


		application.run(args);

	}


	@Override
	public void run(String... args) throws Exception {

	}
}
