package ru.arinageek.ButcherShop.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner userCommandLineRunner(ClientService service) {
        return args -> {
            Client client = new Client(1L,"Arina", "arina435@mail.ru");
            service.addUser(client);
        };
    }
}
