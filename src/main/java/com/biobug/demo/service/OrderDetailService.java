package com.biobug.demo.service;

import com.biobug.demo.model.OrderDetail;
import com.biobug.demo.model.Product;
import com.biobug.demo.repository.IOrderDetailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService implements IOrderDetailService{

    @Autowired
    private IOrderDetailRepository iOrderDetailRepository;
    @Autowired
    private IProductService iProductService;

    @Override
    public List<OrderDetail> getOrderDetails() {
        List<OrderDetail> orderDetails = iOrderDetailRepository.findAll();
        return orderDetails;
    }

    @Override
    public void deleteOrderDetail(Long idOrderDetail) { iOrderDetailRepository.deleteById(idOrderDetail);

    }

    @Override
    public OrderDetail findOrderDetail(Long idOrderDetail) {
        OrderDetail orderDetail = iOrderDetailRepository.findById(idOrderDetail).orElse(null);
        return orderDetail;
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {
        Optional<OrderDetail> orderDetailOptional = iOrderDetailRepository.findById(orderDetail.getIdDetail());
        if(orderDetailOptional.isPresent()){
            OrderDetail orderDetailEntity = orderDetailOptional.get();
        }else{
            System.out.println("OrderDetail no encontrado!");
        }
    }
}
