package ru.arinageek.ButcherShop.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCart() {
        Long userId = 1L; // todo: get userId dynamically
        return cartRepository.getCartByOwnerId(userId);
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }
}
