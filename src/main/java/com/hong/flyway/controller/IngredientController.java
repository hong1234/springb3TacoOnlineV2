package com.hong.flyway.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.hong.flyway.domain.*;
import com.hong.flyway.service.*;

@RestController
@RequestMapping("/api/v1/ingredient")
public class IngredientController { 

    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> getAll() throws ServiceException {
        return ingredientService.getAll();
    }

    @GetMapping("/category")
    public List<Category> getCategories() throws ServiceException {
        return ingredientService.getCategories();
    }
}