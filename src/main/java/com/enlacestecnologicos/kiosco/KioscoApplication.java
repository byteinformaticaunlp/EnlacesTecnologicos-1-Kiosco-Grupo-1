package com.enlacestecnologicos.kiosco;

import com.enlacestecnologicos.kiosco.modelo.Rol;
import com.enlacestecnologicos.kiosco.modelo.Usuario;
import com.enlacestecnologicos.kiosco.repositorios.RolRepository;
import com.enlacestecnologicos.kiosco.repositorios.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KioscoApplication {

	private static final Logger logger = LoggerFactory.getLogger(KioscoApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(KioscoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UsuarioRepository usuario, RolRepository rol) {
		return (args) -> {

			// Creo y guardo roles
            Rol admin = new Rol("administrador");
            Rol repo = new Rol("repositor");
            Rol cajero = new Rol("cajero");
			rol.save(admin);
			rol.save(repo);
			rol.save(cajero);

			// Creo y guardo nuevos usuarios
			usuario.save(new Usuario("David","1234",admin));
			usuario.save(new Usuario("Victor","12345",repo));
			usuario.save(new Usuario("Alan","123456",cajero));
			usuario.save(new Usuario("Ivan","1234567",cajero));

			// fetch all customers
			logger.info("Customers found with findAll():");
			logger.info("-------------------------------");
			usuario.findAll().forEach(customer -> {
				logger.info(customer.getNombre());
			});
			logger.info("");

			// fetch all roles
			logger.info("Roles found with findAll():");
			logger.info("-------------------------------");
			rol.findAll().forEach(roll -> {
				logger.info(roll.getRol().toUpperCase());
			});
			logger.info("");
		};

	};
};