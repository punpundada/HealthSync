package com.healthsync;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HealthSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthSyncApplication.class, args);
	}
	
	@Bean
	 ModelMapper mapper() {
		ModelMapper modelmapper = new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelmapper;	
	}

}
