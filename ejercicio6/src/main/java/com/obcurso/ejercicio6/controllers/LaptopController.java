package com.obcurso.ejercicio6.controllers;

import com.obcurso.ejercicio6.entities.Laptop;
import com.obcurso.ejercicio6.repositories.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
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

    //Metodo para guardar un libro
    @PostMapping("/api/guardarLibro")
    public Laptop saveLaptop(@RequestBody Laptop laptop){
        return repository.save(laptop);
    }

    //Metodo para guardar varios libros
    @PostMapping("/api/guardarLibros")
    public List<Laptop> saveLaptops(@RequestBody List<Laptop> laptops){
        return repository.saveAll(laptops);
    }
}
