package com.neobis.project.kotlinfinal.repositories;

import com.neobis.project.kotlinfinal.entities.CartItemEntity;
import com.neobis.project.kotlinfinal.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItemEntity, Integer> {

    List<CartItem> findCartItemEntitiesByCartId(int id);
    void deleteCartItemEntitiesByCartId(int id);

}
