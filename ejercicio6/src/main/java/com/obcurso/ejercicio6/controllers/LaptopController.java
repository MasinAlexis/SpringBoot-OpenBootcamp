package com.obcurso.ejercicio6.controllers;

import com.obcurso.ejercicio6.entities.Laptop;
import com.obcurso.ejercicio6.repositories.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class LaptopController {

    private LaptopRepository repository;

    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/listar")
    public ResponseEntity<List<Laptop>> findAll(){
        List<Laptop> listLaptops = repository.findAll();
        if (listLaptops.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(listLaptops);
        }
    }

    //Metodo para guardar una laptop
    @PostMapping("/api/guardarLaptop")
    public Laptop saveLaptop(@RequestBody Laptop laptop){
        return repository.save(laptop);
    }

    //Metodo para guardar varias laptops
    @PostMapping("/api/guardarLaptops")
    public List<Laptop> saveLaptops(@RequestBody List<Laptop> laptops){
        return repository.saveAll(laptops);
    }
}
