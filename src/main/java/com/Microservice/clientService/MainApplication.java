package com.Microservice.clientService;

import com.Microservice.clientService.Service.AddressService;
import com.Microservice.clientService.Service.ClientService;
import com.Microservice.clientService.Service.LocationService;
import com.Microservice.clientService.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableFeignClients
@ComponentScan(basePackages = {"com.Microservice.clientService"})
public class MainApplication implements CommandLineRunner {



	public static void main(String[] args) {

		ApplicationContext ctx =SpringApplication.run(MainApplication.class, args);

		ClientService provinceService = ctx.getBean(ClientService.class);

		ClientRequestDTO clientRequestDTO = new ClientRequestDTO()
				.name("MARIA")
				.lastname("BOCCA")
				.dni(17241664)
				.cuil(2343463)
				.birth(LocalDate.now())
				.telephone("2342454044")
				.email("batubasilio@hotmail.com")
				.address(new AddressDTO().id(3)
						.name("barrera")
						.number(1200)
						.location(new LocationDTO()
								.id(1)));


		//System.out.println(provinceService.findAll());
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
