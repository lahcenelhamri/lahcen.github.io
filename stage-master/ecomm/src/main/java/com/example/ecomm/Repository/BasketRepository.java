package com.example.ecomm.Repository;


import com.example.ecomm.Models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
