package fr.diginamic.projetspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages = "fr.diginamic.projetspring")
public class ProjetSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjetSpringApplication.class, args);
    }
}


