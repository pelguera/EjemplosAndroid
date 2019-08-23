package com.pelme.ejemplocardrecyclerview.modelo;

import java.io.Serializable;

public class Pelicula implements Serializable {

    private String nombre;
    private int foto;
    private String tipo;
    private String duracion;

    public Pelicula(String nombre, int foto, String tipo, String duracion) {
        this.nombre = nombre;
        this.foto = foto;
        this.tipo = tipo;
        this.duracion = duracion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
