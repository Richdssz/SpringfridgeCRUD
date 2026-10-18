package dev.richdssz.Fridge.repository;

import dev.richdssz.Fridge.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository é uma interface
public interface FoodRepository extends JpaRepository<Food, Long> {


}
