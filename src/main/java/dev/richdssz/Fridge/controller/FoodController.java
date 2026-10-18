package dev.richdssz.Fridge.controller;

import dev.richdssz.Fridge.model.Food;
import dev.richdssz.Fridge.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/food")
public class FoodController {

    //injeção de dependências
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    //Read
    @GetMapping
    public List<Food> getAll(){return foodService.getAll();}

    @GetMapping("/{id}")
    public Optional<Food> getById(@PathVariable Long id) {return foodService.getById(id);};
    
    //Create
    @PostMapping
    public Food create(@RequestBody Food food){return foodService.save(food);}

    //delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){foodService.delete(id);}

    //update
    @PutMapping("/{id}")
    public Food update(@PathVariable Long id, @RequestBody Food food) {return foodService.update(id,food);}

}
