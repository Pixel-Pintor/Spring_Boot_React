package com.packt.cardatabase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.Owner;

@SpringBootApplication
public class CardatabaseApplication {

	// injectar repositorios
	@Autowired // habilta la injeccion de dependencias
	private CarRepository crepository;

	@Autowired
	private OwnerRepository orepository;

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	public static void main(String[] args) {
		// Despues de agregar este comentario la aplicacion se reinicioa
		SpringApplication.run(CardatabaseApplication.class, args);
		// Mensaje que se muestra en la consola cuando la aplicacion esta corriendo
		logger.info("Hello Spring Boot");
	}

	@Bean
	// Bean para pasar datos a la base de datos H2
	CommandLineRunner runner() {
		return args -> {
			// Agrega datos tipo Car y Owner a la base de datos

			// crea dos nuevas instancias de la entidad Owner
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			// guarda las instancias creadas en el repositorio orepository
			orepository.save(owner1);
			orepository.save(owner2);

			// crea tres nuevas instancias de la entidad Car
			Car car = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
			// guarda las intancias creadas en la base de datos
			crepository.save(car);
			car = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
			crepository.save(car);
			car = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
			crepository.save(car);
		};
	}
}
