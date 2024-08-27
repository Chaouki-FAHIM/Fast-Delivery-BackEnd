package com.fastDelivery;

import com.fastDelivery.entities.*;
import com.fastDelivery.enumerator.Role;
import com.fastDelivery.repo.AdminRepository;
import com.fastDelivery.repo.ClientRepository;
import com.fastDelivery.repo.ColisRepository;
import com.fastDelivery.repo.RamassageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
public class FastDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastDeliveryApplication.class, args);
	}

	@Autowired
	@Qualifier("client_repo")
	private final ClientRepository clientRepository;

	@Autowired
	@Qualifier("colis_repo")
	private final ColisRepository colisRepository;

	@Autowired
	@Qualifier("admin_repo")
	private final AdminRepository adminRepository;

	@Autowired
	@Qualifier("ramassage_repo")
	private final RamassageRepository ramassageRepository;


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
<<<<<<< HEAD
=======
					"hamza_baihi",
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
					"JH875410",
					"123456789123456789123456",
					"CIH BANK");

			clientRepository.save(client);

			Colis colis = new Colis(
					"BAIHI",
					"Hamza",
					"مكناس | Meknès",
					"Lamsalla 03",
					"068755845548",
					25D,
					"أزيلال | Azilal",
					"sbardila",
					"7edi m3ah rah chaffar"
			);

			colisRepository.save(colis);


			Admin admin = new Admin(
					"FAHIM",
					"Chaouki",
					"مكناس | Meknès",
					"Bourj Moulay Omar",
					"0773121957",
					"chaouki@gmail.com",
					"UHUH7259");

			adminRepository.save(admin);

			Ramassage ramassage = new Ramassage(
					"FAHIM",
					"Reda",
					"مكناس | Meknès",
					"Bourj Moulay Omar",
					"0787451215",
					"Rah waled nas"
			);

			ramassageRepository.save(ramassage);

		};
	}
}
