package com.example.cart_service.controller;

import com.example.cart_service.model.Cart; // Import the Cart model
import com.example.cart_service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public Cart addToCart(@RequestBody Cart cartItem) {
        return cartService.addToCart(cartItem.getBookId(), cartItem.getQuantity());
    }

    @GetMapping
    public List<Cart> getCartItems() {
        return cartService.getAllCartItems();
    }

    @DeleteMapping("/{id}")
    public String removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return "Item removed from cart successfully.";
    }

    @DeleteMapping
    public String clearCart() {
        cartService.clearCart();
        return "Cart cleared successfully";
    }

    @PostMapping("/purchase")
    public String purchaseCart() {
        cartService.clearCart();
        return "Purchase successful and cart cleared.";
    }
}
