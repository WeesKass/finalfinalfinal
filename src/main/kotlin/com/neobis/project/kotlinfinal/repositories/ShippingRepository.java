package com.neobis.project.kotlinfinal.repositories;

import com.neobis.project.kotlinfinal.entities.ShippingEntity;
import com.neobis.project.kotlinfinal.entities.ShippingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingEntity, Integer> {
}
