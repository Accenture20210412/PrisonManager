package pl.lsab.prisonmanagerproject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.persistence.Entity;
import javax.sql.DataSource;

@SpringBootApplication
public class PrisonManagerProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrisonManagerProjectApplication.class, args);
    }


}
