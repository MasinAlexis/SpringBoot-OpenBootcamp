package com.obcurso.ejercicio9.controllers;

import com.obcurso.ejercicio9.entities.Laptop;
import com.obcurso.ejercicio9.repositories.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private LaptopRepository repository;

    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }

    //Metodo para listar todas - findAll()
    @GetMapping("/api/listar")
    public ResponseEntity<List<Laptop>> findAll(){
        List<Laptop> listLaptops = repository.findAll();
        if (listLaptops.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(listLaptops);
        }
    }

    //Metodo para listar una laptop - findOneById()
    @GetMapping("api/listar/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopResult = repository.findById(id);
        if (laptopResult.isPresent()){
            return ResponseEntity.ok(laptopResult.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Metodo para guardar una laptop - create()
    @PostMapping("/api/guardarLaptop")
    public Laptop create(@RequestBody Laptop laptop){
        return repository.save(laptop);
    }

    //Metodo para actualizar laptop - update()
    @PutMapping("/api/actualizar")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        Optional<Laptop> laptopFind = repository.findById(laptop.getIdLaptop());
        if (laptopFind.isPresent()){
            return ResponseEntity.ok(repository.save(laptop));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    //Metodo para eliminar una laptop / delete()
    @DeleteMapping("/api/eliminar/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Optional<Laptop> laptopFind = repository.findById(id);
        if (laptopFind.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //Metodo para borrar todas las laptops / deleteAll()
    @DeleteMapping("/api/borrarLaptops")
    public ResponseEntity deleteAll(){
        List<Laptop> listaLaptops = repository.findAll();
        if (listaLaptops.size() > 0){
            repository.deleteAll();
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    //Metodo para guardar varios libros
    @PostMapping("/api/guardarLaptops")
    public List<Laptop> saveLaptops(@RequestBody List<Laptop> laptops){
        return repository.saveAll(laptops);
    }
}
