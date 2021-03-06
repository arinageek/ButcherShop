package ru.arinageek.ButcherShop.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ru.arinageek.ButcherShop.session.SessionService.ADMIN_ID;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner userCommandLineRunner(ClientService service) {
        return args -> {
            Client client = new Client(ADMIN_ID, true,"Arina", "arina435@mail.ru");
            service.addUser(client);
        };
    }
}
