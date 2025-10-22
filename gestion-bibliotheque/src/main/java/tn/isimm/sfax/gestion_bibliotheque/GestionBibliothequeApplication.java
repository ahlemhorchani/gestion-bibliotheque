package tn.isimm.sfax.gestion_bibliotheque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "tn.isimm.sfax.bibliotheque")
@EntityScan("tn.isimm.sfax.bibliotheque.entity")
@EnableJpaRepositories("tn.isimm.sfax.bibliotheque.repository")
public class GestionBibliothequeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionBibliothequeApplication.class, args);
    }
}