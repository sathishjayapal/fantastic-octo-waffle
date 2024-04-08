package me.sathish.ai.fantasticoctowaffle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FantasticOctoWaffleApplication {

	final
	FantasticClient fantasticClient;

	public FantasticOctoWaffleApplication(FantasticClient fantasticClient, FantasticClient fantasticClient1) {
		this.fantasticClient = fantasticClient;

	}

	public static void main(String[] args) {
		SpringApplication.run(FantasticOctoWaffleApplication.class, args);
	}

}
