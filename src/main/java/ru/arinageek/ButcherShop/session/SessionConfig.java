package ru.arinageek.ButcherShop.session;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ru.arinageek.ButcherShop.session.SessionService.ADMIN_ID;

@Configuration
public class SessionConfig {

    @Bean
    CommandLineRunner sessionCommandLineRunner(SessionRepository repository) {
        return args -> {
            Session session = new Session(ADMIN_ID);
            repository.save(session);
        };
    }
}
