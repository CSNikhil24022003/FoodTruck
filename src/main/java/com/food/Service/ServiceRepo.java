package com.food.Service;

import java.util.List;

import com.food.entity.Customer;

public interface ServiceRepo {
public List<Customer> getFood();
public String insertCus(Customer c);
public String updateCus(Customer c);
public String deleteCus(Integer id);

}
