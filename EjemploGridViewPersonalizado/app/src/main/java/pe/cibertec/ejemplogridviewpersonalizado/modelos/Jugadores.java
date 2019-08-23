package pe.cibertec.ejemplogridviewpersonalizado.modelos;

import java.io.Serializable;

public class Jugadores implements Serializable {

    private String nombre;
    private String descripcion;
    private String nombreFoto;
    private String nombreEquipo;

    public Jugadores(String nombre, String descripcion, String nombreFoto, String nombreEquipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nombreFoto = nombreFoto;
        this.nombreEquipo = nombreEquipo;
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

    public String getNombreFoto() {
        return nombreFoto;
    }

    public void setNombreFoto(String nombreFoto) {
        this.nombreFoto = nombreFoto;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
}
