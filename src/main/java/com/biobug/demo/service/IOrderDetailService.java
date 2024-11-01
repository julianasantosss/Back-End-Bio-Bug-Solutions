package com.biobug.demo.service;

import com.biobug.demo.model.OrderDetail;

import java.util.List;

public interface IOrderDetailService {

    public List<OrderDetail> getOrderDetail();
    public void deleteOrderDetail(Long id_orderDetail);
    public OrderDetail findOrderDetail (Long id_orderDetail);
}
