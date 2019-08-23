package com.pelme.consumoservicioscardview.modelo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListaHeroes {

    @SerializedName("results")
    private List<Heroe> listaHeroes;

    public List<Heroe> getListaHeroes() {
        return listaHeroes;
    }

    public void setListaHeroes(List<Heroe> listaHeroes) {
        this.listaHeroes = listaHeroes;
    }
}
