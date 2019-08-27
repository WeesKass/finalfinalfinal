package com.neobis.project.kotlinfinal.repositories;

import com.neobis.project.kotlinfinal.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
