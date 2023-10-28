package com.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entity.Food;

public interface FoodRepo extends JpaRepository<Food,Integer> {
	public Food findByFname(String name);
	

}
