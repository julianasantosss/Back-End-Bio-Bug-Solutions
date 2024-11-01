package com.biobug.demo.service;

import com.biobug.demo.model.OrderDetail;
import com.biobug.demo.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService{

    @Autowired
    private IOrderDetailRepository iOrderDetailRepository;


    @Override
    public List<OrderDetail> getOrderDetail() {
        List<OrderDetail> orderDetails = iOrderDetailRepository.findAll();
        return orderDetails;
    }

    @Override
    public void deleteOrderDetail(Long id_orderDetail) { iOrderDetailRepository.deleteById(id_orderDetail);

    }

    @Override
    public OrderDetail findOrderDetail(Long id_orderDetail) {
        OrderDetail orderDetail = iOrderDetailRepository.findById(id_orderDetail).orElse(null);
        return orderDetail;
    }
}
