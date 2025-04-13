package com.projeto.pedrohenriqueesteves_pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.projeto")
@EntityScan(basePackages = {"com.projeto.domains","com.atividade.domains.enums"})
@EnableJpaRepositories(basePackages = {"com.projeto.repositories"})
@SpringBootApplication
public class PedrohenriqueestevesPokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedrohenriqueestevesPokemonApplication.class, args);
	}

}
