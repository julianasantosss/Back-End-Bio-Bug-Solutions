package com.biobug.demo.service;

import com.biobug.demo.model.Order;
import com.biobug.demo.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public List<Order> getOrder() {
        List<Order> orderList = iOrderRepository.findAll();
        return orderList;
    }

    @Override
    public void saveOrder(Order order) { iOrderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id_Order) { iOrderRepository.deleteById(id_Order);
    }

    @Override
    public Order findOrder(Long id_Order) { return iOrderRepository.findById(id_Order).orElse(null); }
}
