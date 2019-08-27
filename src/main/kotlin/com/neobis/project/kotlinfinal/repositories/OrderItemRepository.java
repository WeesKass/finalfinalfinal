package com.neobis.project.kotlinfinal.repositories;

import com.neobis.project.kotlinfinal.entities.OrderItemEntity;
import com.neobis.project.kotlinfinal.entities.OrderItemEntityPK;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemEntityPK> {

}
