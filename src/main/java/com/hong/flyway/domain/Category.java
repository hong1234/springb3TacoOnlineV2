package com.hong.flyway.domain;

import java.util.List;

public record Category(
    String name,
    String title, 
    List<Ingredient> items
) {}