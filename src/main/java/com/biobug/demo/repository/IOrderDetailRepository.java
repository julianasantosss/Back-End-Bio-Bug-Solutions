package com.biobug.demo.repository;

import com.biobug.demo.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
