package ru.arinageek.ButcherShop.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.arinageek.ButcherShop.session.SessionService;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final SessionService sessionService;

    @Autowired
    public CartService(CartRepository cartRepository, SessionService sessionService) {
        this.cartRepository = cartRepository;
        this.sessionService = sessionService;
    }

    public Cart getCart() {
        Long userId = sessionService.getCurrentUser().getId();
        return cartRepository.getCartByOwnerId(userId);
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }
}
