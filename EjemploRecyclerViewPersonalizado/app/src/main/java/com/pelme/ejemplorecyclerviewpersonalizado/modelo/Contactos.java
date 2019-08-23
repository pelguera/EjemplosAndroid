package com.pelme.ejemplorecyclerviewpersonalizado.modelo;

import java.io.Serializable;

public class Contactos implements Serializable {

    private String nombre;
    private String descripcion;
    private int idFoto;
    private String telefono;
    private int edad;
    private String direccion;

    public Contactos(String nombre, String descripcion, int idFoto, String telefono, int edad, String direccion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idFoto = idFoto;
        this.telefono = telefono;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

}
