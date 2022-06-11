package ru.arinageek.ButcherShop.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.arinageek.ButcherShop.Order.Order;
import ru.arinageek.ButcherShop.email.EmailService;
import ru.arinageek.ButcherShop.meat.MeatService;
import ru.arinageek.ButcherShop.session.SessionService;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final SessionService sessionService;
    private final MeatService meatService;
    private final EmailService emailService;

    @Autowired
    public CartService(CartRepository cartRepository, SessionService sessionService, MeatService meatService, EmailService emailService) {
        this.cartRepository = cartRepository;
        this.sessionService = sessionService;
        this.meatService = meatService;
        this.emailService = emailService;
    }

    public Cart getCart() {
        Long userId = sessionService.getCurrentUser().getId();
        Cart cart = cartRepository.getCartByOwnerId(userId);
        return cart;
    }

    public void sendOrderEmail(Order order) {
        emailService.sendNotification(order);
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }
}
