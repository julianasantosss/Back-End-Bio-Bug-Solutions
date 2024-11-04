package com.biobug.demo.controller;


import com.biobug.demo.model.OrderDetail;
import com.biobug.demo.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detail")
public class OrderDetailController {
    @Autowired
    private IOrderDetailService iOrderDetailService;

    public List<OrderDetail> getAllOrderDetail(){
        return iOrderDetailService.getOrderDetails();
    }


    @PutMapping
    public void updateOrderDetail(OrderDetail orderDetail){
        iOrderDetailService.updateOrderDetail(orderDetail);
    }

//    {
//        "product": {
//        "idProduct": 1  // Reemplaza este valor con el ID del producto existente en la base de datos
//    },
//        "quantity": 3,  // Cantidad del producto en este detalle del pedido
//            "price": 49.99  // Precio del producto para este pedido
//    }

}
