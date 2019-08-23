package com.pelme.ejemplorecyclerviewbbva;

public class Contacto {

    private String nombreContacto;
    private int idFoto;

    public Contacto(String nombreContacto, int idFoto) {
        this.nombreContacto = nombreContacto;
        this.idFoto = idFoto;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }
}
