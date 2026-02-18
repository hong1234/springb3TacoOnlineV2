package com.hong.flyway.service;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.transaction.annotation.Transactional;

import com.hong.flyway.repository.*;
import com.hong.flyway.domain.*;

// @Transactional
@RequiredArgsConstructor
@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository; 

    public List<Ingredient> getAll() throws ServiceException {  
        return ingredientRepository.findAll(); 
    }

    public List<Category> getCategories() throws ServiceException {
        List<Ingredient> ingredients = ingredientRepository.findAll(); 

        List<Category> categories = new ArrayList<>();
        IngredientType[] types = IngredientType.values();
        for (IngredientType type : types) {
            String name = type.toString().toLowerCase();
            String title = "";
            if(name.equals("wrap"))
                title = "Designate your wrap";
            if(name.equals("protein"))
                title = "Pick your protein";
            if(name.equals("veggies"))
                title = "Determine your veggies";
            if(name.equals("cheese"))
                title = "Choose your cheese";
            if(name.equals("sauce"))
                title = "Select your sauce";
            if(name.equals("drinks"))
                title = "and perhaps a drink";

            categories.add(new Category(name, title, filterByType(ingredients, type)));
        }

        return categories;
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, IngredientType type) {
        return ingredients
              .stream()
              .filter(x -> x.getIngredientType().equals(type))
              .collect(Collectors.toList());
    }

    public Ingredient newIngredient() throws ServiceException {
        Ingredient ing = new Ingredient();
        ing.setMark("THIT");
        ing.setName("Thit lon");
        ing.setIngredientType(IngredientType.valueOf("PROTEIN"));
        ing = ingredientRepository.save(ing);
        return ing;
    }

}