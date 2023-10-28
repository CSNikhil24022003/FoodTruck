package com.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entity.Customer;

public interface CusRepo extends JpaRepository<Customer,Integer> {

}
