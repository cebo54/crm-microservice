package com.turkcell.cartservice.repository;

import com.turkcell.cartservice.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, String> {


}
