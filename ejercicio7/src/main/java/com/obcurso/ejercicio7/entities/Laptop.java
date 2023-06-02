package com.obcurso.ejercicio7.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="laptop")
public class Laptop implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idlaptop;

    private String marca;

    private String modelo;

    private int memDisco; //En GB

    private int memRam; //En GB

    private String microprocesador;

    public Laptop() {}

    public Laptop(Long idlaptop, String marca, String modelo, int memDisco, int memRam, String microprocesador) {
        this.idlaptop = idlaptop;
        this.marca = marca;
        this.modelo = modelo;
        this.memDisco = memDisco;
        this.memRam = memRam;
        this.microprocesador = microprocesador;
    }

    public Long getIdLaptop() {
        return idlaptop;
    }
    public void setIdLaptop(Long idLaptop) {
        this.idlaptop = idLaptop;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getMemDisco() {
        return memDisco;
    }
    public void setMemDisco(int memDisco) {
        this.memDisco = memDisco;
    }

    public int getMemRam() {
        return memRam;
    }
    public void setMemRam(int memRam) {
        this.memRam = memRam;
    }

    public String getMicroprocesador() {
        return microprocesador;
    }
    public void setMicroprocesador(String microprocesador) {
        this.microprocesador = microprocesador;
    }
}
