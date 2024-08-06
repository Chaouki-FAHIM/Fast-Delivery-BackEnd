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

			Client client = Client.builder()
					.email("hamza@gmail.com")
					.password("7814PAOIL")
					.username("hamza_baihi")
					.dateCreation(new Date())
					.prenom("Hamza")
					.nom("BAIHI")
					.ville("Meknès")
					.numeroTelephone("068755845548")
					.CIN("JH875410")
					.rib("123456789123456789123456")
					.banque("CIH BANK")
					.build();
			clientRepository.save(client);
		};
	}
}
