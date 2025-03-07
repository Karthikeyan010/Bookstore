package com.example.cart_service.repository;

import com.example.cart_service.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByBookId(Long bookId);
}
