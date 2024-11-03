package com.biobug.demo.service;



import com.biobug.demo.model.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    public List<OrderDetail> getOrderDetails();
    public void deleteOrderDetail(Long idOrderDetail);
    public OrderDetail findOrderDetail (Long idOrderDetail);
    public void updateOrderDetail( OrderDetail orderDetail);


}
