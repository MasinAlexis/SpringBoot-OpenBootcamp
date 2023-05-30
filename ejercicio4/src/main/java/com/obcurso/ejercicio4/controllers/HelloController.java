package com.obcurso.ejercicio4.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/saludo")
    public String retornarSaludo(){
        return "Saludando desde Controlador REST";
    }
}