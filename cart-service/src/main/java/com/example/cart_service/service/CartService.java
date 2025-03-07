package com.example.cart_service.service;

import com.example.cart_service.model.Cart;
import com.example.cart_service.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart addToCart(Long bookId, int quantity) {
        Cart cartItem = new Cart(bookId, quantity);
        return cartRepository.save(cartItem);
    }

    public List<Cart> getAllCartItems() {
        return cartRepository.findAll();
    }

    public void clearCart() {
        cartRepository.deleteAll();
    }

    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }

}
