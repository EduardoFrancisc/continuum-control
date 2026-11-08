package br.edu.infnet.continuum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ContinuumControlApplication {
	public static void main(String[] args) {
		SpringApplication.run(ContinuumControlApplication.class, args);
	}
}
