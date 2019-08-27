package com.neobis.project.kotlinfinal.services;

import com.neobis.project.kotlinfinal.entities.CartItemEntity;
import com.neobis.project.kotlinfinal.exception.RecordNotFoundException;
import com.neobis.project.kotlinfinal.models.CartItem;
import com.neobis.project.kotlinfinal.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;


    public CartItem saveCartItem(CartItem cartItem) {
        CartItemEntity saveResult = cartItemRepository.save(cartItem.convertToEntity());
        return new CartItem(saveResult);
    }

    public void deleteCartItemById(int productId) {
        cartItemRepository.deleteById(productId);
    }

    public List<CartItem> getAllCartItem(int id) {
        return cartItemRepository.findCartItemEntitiesByCartId(id);
    }

    public void deleteCartItemByIdCartId(int id){
        cartItemRepository.deleteCartItemEntitiesByCartId(id);
    }
}
