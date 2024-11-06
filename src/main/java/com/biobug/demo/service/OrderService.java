package com.biobug.demo.service;

import com.biobug.demo.model.Order;
import com.biobug.demo.model.OrderDetail;
import com.biobug.demo.model.Product;
import com.biobug.demo.model.User;
import com.biobug.demo.repository.IOrderDetailRepository;
import com.biobug.demo.repository.IOrderRepository;
import com.biobug.demo.repository.IProductRepository;
import com.biobug.demo.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository iOrderRepository;
    @Autowired
    private IOrderDetailRepository iOrderDetailRepository;
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Order> getOrders() {
        List<Order> orderList = iOrderRepository.findAll();
        return orderList;
    }
    @Transactional
    @Override
    public void saveOrder(Order orderRequest) {
            Order order = new Order();
            order.setDateCreation(orderRequest.getDateCreation());

            User user = iUserRepository.findById(orderRequest.getUser().getIdUser())
                    .orElseThrow(() -> new IllegalArgumentException("User does not exist: " + orderRequest.getUser().getIdUser()));
            order.setUser(user);

            List<OrderDetail> orderDetails = new ArrayList<>();

            for (OrderDetail detail : orderRequest.getOrderDetails()) {
                Product product = iProductRepository.findById(detail.getIdProduct())
                        .orElseThrow(() -> new IllegalArgumentException("Product does not exist: " + detail.getIdProduct()));

                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setQuantity(detail.getQuantity());
                orderDetail.setPrice(product.getPrice());
                orderDetail.setIdProduct(product.getIdProduct());

                order.addOrderDetail(orderDetail);
                order.setDiscount(orderRequest.getDiscount());
                order.setSubTotal(orderRequest.getSubTotal());
                order.setTotal(orderRequest.getTotal());
//                order.calculateSubTotal();
//                order.calculateTotal(orderRequest.getDiscount());
            }
            iOrderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long idOrder) { iOrderRepository.deleteById(idOrder);
    }

    @Override
    public Order findOrder(Long idOrder) { return iOrderRepository.findById(idOrder).orElse(null); }
    @Transactional
    @Override
    public void editOrder(Order order) {
        Order orderEntity = iOrderRepository.getReferenceById(order.getIdOrder());
        if(orderEntity != null){
            orderEntity.updateOrder(order);
        }
    }
    @Transactional
    @Override
    public void deleteOrderDetail(Long idOrder, Long idOrderDetail) {
        Order order = iOrderRepository.getReferenceById(idOrder);
        if(order != null){
            OrderDetail orderDetail = iOrderDetailRepository.findById(idOrderDetail).orElse(null);
            if(orderDetail != null){
                order.deleteOrderDetail(idOrderDetail);
            }
        }
    }
}
