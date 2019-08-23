package com.example.admin.t5bmsemana4.bean;

/**
 * Created by admin on 10/09/2016.
 */
public class LibroBean {
    private String idlibro;
    private String nombre;
    private String autor;
    private String portada;

    public String toString(){
        return  nombre;
    }

    public String getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(String idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}
