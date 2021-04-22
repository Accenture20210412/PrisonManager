package pl.lsab.prisonmanagerproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

@SpringBootApplication
public class PrisonManagerProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrisonManagerProjectApplication.class, args);
    }

}
