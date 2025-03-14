package com.example.cart_service.controller;

import com.example.cart_service.model.Cart;
import com.example.cart_service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public Cart addToCart(@RequestBody Cart cartItem) {
        logger.info("Adding item to cart: {}", cartItem);
        Cart addedItem = cartService.addToCart(cartItem.getBookId(), cartItem.getQuantity());
        logger.info("Item added to cart: {}", addedItem);
        return addedItem;
    }

    @GetMapping
    public List<Cart> getCartItems() {
        logger.info("Fetching all cart items");
        List<Cart> cartItems = cartService.getAllCartItems();
        logger.info("Cart items fetched: {}", cartItems);
        return cartItems;
    }

    @DeleteMapping("/{id}")
    public String removeFromCart(@PathVariable Long id) {
        logger.info("Removing item from cart with id: {}", id);
        cartService.removeFromCart(id);
        logger.info("Item removed from cart with id: {}", id);
        return "Item removed from cart successfully.";
    }

    @DeleteMapping
    public String clearCart() {
        logger.info("Clearing cart");
        cartService.clearCart();
        logger.info("Cart cleared");
        return "Cart cleared successfully";
    }

    @PostMapping("/purchase")
    public String purchaseCart() {
        logger.info("Purchasing cart");
        cartService.clearCart();
        logger.info("Purchase successful and cart cleared");
        return "Purchase successful and cart cleared.";
    }

}
