package com.neobis.project.kotlinfinal.controllers;

import com.neobis.project.kotlinfinal.entities.OrderItemEntityPK;
import com.neobis.project.kotlinfinal.models.OrderItem;
import com.neobis.project.kotlinfinal.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("/")
    public String defaultOrderItem() {
        return "Default orderItem endpoint";
    }


    // get all order items by order_id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OrderItem getOrderItemById(@PathVariable("id") OrderItemEntityPK id) throws Exception {
        return orderItemService.getOrderItemById(id);
    }


    // create new order item
    @RequestMapping(method = RequestMethod.POST)
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.saveOrderItem(orderItem);
    }


    //delete an order item
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteOrderItemById(@PathParam("id") OrderItemEntityPK id) {
        orderItemService.deleteOrderItemById(id);
    }

}