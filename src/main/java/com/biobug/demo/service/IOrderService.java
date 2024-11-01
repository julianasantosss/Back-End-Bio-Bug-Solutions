package com.biobug.demo.service;

import com.biobug.demo.model.Order;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IOrderService {

    public List<Order> getOrder();
    public void saveOrder(Order order);
    public void deleteOrder(Long id_Order);
    public Order findOrder(Long id_Order);
}
