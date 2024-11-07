package com.biobug.demo.controller;


import com.biobug.demo.dto.OrderDTO;
import com.biobug.demo.dto.OrderListDTO;
import com.biobug.demo.model.Order;
import com.biobug.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody Order order){
       return ResponseEntity.ok(new OrderDTO(iOrderService.saveOrder(order)))  ;
    }

    @GetMapping
    public List<OrderListDTO> getAllOrders(){
        return iOrderService.getOrders().stream().map(OrderListDTO::new).toList();
    }
    @PutMapping
    public void editOrder(@RequestBody Order order){
        iOrderService.editOrder(order);
    }
    @DeleteMapping
    public void deleteOrder( Long idOrder){
        iOrderService.deleteOrder(idOrder);
    }
    @PutMapping("/{idOrder}/{idOrderDetail}")
    public void deleteOrderDetailOfOrder( Long idOrder, Long idOrderDetail){
        iOrderService.deleteOrderDetail(idOrder, idOrderDetail);
    }

}
