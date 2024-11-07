package com.biobug.demo.service;

import com.biobug.demo.model.Order;

import java.util.List;

public interface IOrderService {

    public List<Order> getOrders();
    public Order saveOrder(Order order);
    public void deleteOrder(Long idOrder);
    public Order findOrder(Long idOrder);
    public void editOrder(Order order);
    public void deleteOrderDetail( Long idOrder, Long idOrderDetail);

}
