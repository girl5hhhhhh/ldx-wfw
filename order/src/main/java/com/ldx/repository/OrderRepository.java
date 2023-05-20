package com.ldx.repository;

import com.ldx.repository.info.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderInfo,Integer> {
}
