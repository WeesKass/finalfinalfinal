package com.neobis.project.kotlinfinal.services;

import com.neobis.project.kotlinfinal.entities.OrderItemEntity;
import com.neobis.project.kotlinfinal.entities.OrderItemEntityPK;
import com.neobis.project.kotlinfinal.exception.RecordNotFoundException;
import com.neobis.project.kotlinfinal.models.OrderItem;
import com.neobis.project.kotlinfinal.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem getOrderItemById(OrderItemEntityPK orderId) throws Exception{
        return new OrderItem(orderItemRepository.findById(orderId).orElseThrow(RecordNotFoundException::new));
    }

    public OrderItem saveOrderItem(OrderItem orderItem) {
        OrderItemEntity saveResult = orderItemRepository.save(orderItem.convertToEntity());
        return new OrderItem(saveResult);
    }

    public void deleteOrderItemById(OrderItemEntityPK orderId) {
        orderItemRepository.deleteById(orderId);
    }
}
