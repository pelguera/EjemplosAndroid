package com.pelme.ejemplotabs.modelo;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nombrePersona;
    private Pais pais;

    public Persona(String nombrePersona, Pais pais) {
        this.nombrePersona = nombrePersona;
        this.pais = pais;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
