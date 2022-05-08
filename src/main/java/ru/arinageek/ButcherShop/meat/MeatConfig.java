package ru.arinageek.ButcherShop.meat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MeatConfig {

    @Bean
    CommandLineRunner meatCommandLineRunner(MeatRepository repository) {
        return args -> {
            Meat bacon = new Meat("Pork", "Bacon", "This is a tasty bacon", 200.0);
            Meat brisket = new Meat("Beef", "Brisket", "This is a tasty brisket", 350.0);
            repository.saveAll(List.of(bacon, brisket));
        };
    }
}
