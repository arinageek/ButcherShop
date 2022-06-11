package ru.arinageek.ButcherShop.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.arinageek.ButcherShop.Order.Order;
import ru.arinageek.ButcherShop.cart.CartConfig;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Service
public class EmailService {
    public static final String EMAIL = "arina435979@yandex.ru";
    @Autowired
    private CartConfig cartConfig;
    private JavaMailSender javaMailSender;

    @PostConstruct
    private void mailSettings() {
        javaMailSender = cartConfig.getJavaMailSender();
    }

    @Async
    public void sendNotification(Order order) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(EMAIL);
        mail.setFrom(EMAIL);
        mail.setSubject("New order at " +
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                .format(LocalDateTime.now()));
        mail.setText(order.toString());

        javaMailSender.send(mail);
    }

}
