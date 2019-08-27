package com.neobis.project.kotlinfinal.repositories;

import com.neobis.project.kotlinfinal.entities.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerEntity, Integer> {
}
