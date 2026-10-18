package dev.richdssz.Fridge.services;

import dev.richdssz.Fridge.model.Food;
import dev.richdssz.Fridge.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    // Listar todas as comidas
    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    // Listar uma comida
    public Optional<Food> getById(Long id) {
        return foodRepository.findById(id);
    }

    // Criar comida
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    // Deletar comida
    public void delete(Long id) {
        foodRepository.deleteById(id);
    }
    // editar comida

    // atualizar comida
    public Food update(Long id, Food newFood) {
        Food foodExistente = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alimento não encontrado com ID: " + id));

        foodExistente.setName(newFood.getName());
        foodExistente.setQuantity(newFood.getQuantity());
        foodExistente.setExpirationDate(newFood.getExpirationDate());

        return foodRepository.save(foodExistente);
    }

}
