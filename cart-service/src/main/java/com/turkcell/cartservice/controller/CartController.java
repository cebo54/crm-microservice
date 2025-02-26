package com.turkcell.cartservice.controller;

import com.turkcell.cartservice.entity.Cart;
import com.turkcell.cartservice.repository.CartRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartRepository cartRepository;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    @GetMapping
    public String getCart() {
        return "cart-service";
    }

    @PostMapping
    public void add(@RequestBody Cart cart) {
        cartRepository.save(cart);
    }
}
