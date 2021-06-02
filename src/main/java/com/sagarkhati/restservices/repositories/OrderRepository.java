package com.sagarkhati.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sagarkhati.restservices.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
