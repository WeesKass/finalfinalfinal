package com.neobis.project.kotlinfinal.services;

import com.neobis.project.kotlinfinal.entities.CartEntity;
import com.neobis.project.kotlinfinal.exception.RecordNotFoundException;
import com.neobis.project.kotlinfinal.models.Cart;
import com.neobis.project.kotlinfinal.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart getCartById(int cartId) throws Exception {
        return new Cart(cartRepository.findById(cartId).orElseThrow(RecordNotFoundException::new));
    }

    public Cart saveCart(Cart cart) {
        CartEntity saveResult = cartRepository.save(cart.convertToEntity());
        return new Cart(saveResult);
    }

    public void deleteCartById(int cartId) {
        cartRepository.deleteById(cartId);
    }
}
