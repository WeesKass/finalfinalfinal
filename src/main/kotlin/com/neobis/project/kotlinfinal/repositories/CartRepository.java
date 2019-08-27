package com.neobis.project.kotlinfinal.repositories;

import com.neobis.project.kotlinfinal.entities.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity, Integer> {

}
