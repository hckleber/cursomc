package com.kleberhc.cursomc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {


	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	
//	Implements CommandLineRuner permite implementar 
//	método auxiliar para executar alguma ação quando a aplicação iniciar
	@Override
	public void run(String... args) throws Exception {
	
		
	}
	
	
	
}


