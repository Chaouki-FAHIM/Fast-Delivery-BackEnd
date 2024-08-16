package com.fastDelivery;

import com.fastDelivery.entities.Client;
import com.fastDelivery.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class FastDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastDeliveryApplication.class, args);
	}

	@Autowired
	@Qualifier("client_repo")
	private ClientRepository clientRepository;

	@Bean
	CommandLineRunner initDB() {
		return args -> {

			Client client = new Client(
					"BAIHI",
					"Hamza",
					"مكناس | Meknès",
					"Lamsalla 03",
					"068755845548",
					"hamza@gmail.com",
					"7814PAOIL",
					"hamza_baihi",
					"JH875410",
					"123456789123456789123456",
					"CIH BANK");

			clientRepository.save(client);
		};
	}
}
