package com.pelme.consumoservicioscardview.interfaces;

import com.pelme.consumoservicioscardview.modelo.ListaHeroes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SuperHeroInterface {

    @GET("search/{name}")
    Call<ListaHeroes> getListaHeroes(@Path("name") String nombre);
}
