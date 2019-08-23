package com.example.l2practicajava;

import java.io.Serializable;

public class SuperH implements Serializable {
    private String id;
    private String nombre;
    private String foto;

    public SuperH(String id, String nombre, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFoto() {
        return foto;
    }
}
