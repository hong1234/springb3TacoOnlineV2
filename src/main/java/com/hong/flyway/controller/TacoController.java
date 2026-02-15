package com.hong.flyway.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.hong.flyway.domain.*;
import com.hong.flyway.service.*;

@RestController
@RequestMapping("/api/v1/taco")
public class TacoController { 

    private TacoService tacoService;

    public TacoController(TacoService tacoService) {
        this.tacoService = tacoService;
    }

    @GetMapping("/{tacoId}")
    public Taco getTaco(@PathVariable Integer tacoId) throws ServiceException {
        return tacoService.getTaco(tacoId);
    }

    // @PostMapping("/design")
    // public Cart newTaco(@RequestBody TacoDTO dto) throws ServiceException {
    //     return tacoService.newTaco(dto);
    // }
}