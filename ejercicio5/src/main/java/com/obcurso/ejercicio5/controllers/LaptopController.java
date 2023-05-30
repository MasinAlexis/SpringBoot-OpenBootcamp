package com.obcurso.ejercicio5.controllers;

import com.obcurso.ejercicio5.entities.Laptop;
import com.obcurso.ejercicio5.repositories.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {

    private LaptopRepository repository;

    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/listar")
    public List<Laptop> findAll(){
        return repository.findAll();
    }
}
