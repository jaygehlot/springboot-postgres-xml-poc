package com.mands.springboot.jpapostgres.example.persistance;

import com.mands.springboot.jpapostgres.example.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

}
