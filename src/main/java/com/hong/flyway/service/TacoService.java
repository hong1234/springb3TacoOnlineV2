package com.hong.flyway.service;

// import java.util.UUID;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import com.hong.flyway.repository.*;
import com.hong.flyway.domain.*;

@Transactional
@RequiredArgsConstructor
@Service
public class TacoService {

    private final TacoRepository tacoRepository; 
    private final IngredientRepository ingredientRepository;
    private final CartRepository cartRepository;

    public Taco getTaco(Integer tacoId) throws ServiceException {
        Taco taco = tacoRepository.findById(tacoId).get(); 
        return taco;
    }
    
    // public Taco newTaco(TacoDTO dto) throws ServiceException {
    //     int[] ingredients = dto.getIngredients();
    //     Cart cart = cartRepository.findById(1).get();

    //     Taco taco = new Taco();
    //     taco.setName(dto.getName());
    //     taco.setCart(cart);
    //     for (int i = 0; i < ingredients.length; i++){
    //         // taco.getIngredients().add(ingredientRepository.findById(ingredients[i]).get());
    //         taco.addIngredient(ingredientRepository.findById(ingredients[i]).get());
    //     }
        
    //     return tacoRepository.save(taco);
    //     // return taco;
    // }
    
}