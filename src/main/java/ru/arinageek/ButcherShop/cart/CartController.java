package ru.arinageek.ButcherShop.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.arinageek.ButcherShop.meat.Meat;
import ru.arinageek.ButcherShop.meat.MeatService;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final MeatService meatService;

    @Autowired
    public CartController(CartService cartService, MeatService meatService) {
        this.cartService = cartService;
        this.meatService = meatService;
    }

    @GetMapping
    public String getCart(Model model) {
        model.addAttribute("cart", cartService.getCart());
        return "showCart";
    }

    @GetMapping("/addMeat/{meatId}")
    public String addMeatToCart(@PathVariable Long meatId) {
        Cart cart = cartService.getCart();
        Meat meat = meatService.getMeatById(meatId);
        cart.addMeat(meat);
        cartService.saveCart(cart);
        return "redirect:/cart";
    }

    @GetMapping("/removeMeat/{meatId}")
    public String removeMeatFromCart(@PathVariable Long meatId) {
        Cart cart = cartService.getCart();
        Meat meat = meatService.getMeatById(meatId);
        cart.removeMeat(meat);
        cartService.saveCart(cart);
        return "redirect:/cart";
    }
}
