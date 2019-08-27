package com.neobis.project.kotlinfinal.repositories;

import com.neobis.project.kotlinfinal.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findOrdersByCustomerId(int customerId);
    List<OrderEntity> findOrdersByShippingId(int shippingId);
}
