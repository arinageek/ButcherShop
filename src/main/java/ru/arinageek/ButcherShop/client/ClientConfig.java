package ru.arinageek.ButcherShop.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner userCommandLineRunner(ClientRepository repository) {
        return args -> {
            Client client = new Client("Arina", "arina435@mail.ru");
            repository.save(client);
        };
    }
}
