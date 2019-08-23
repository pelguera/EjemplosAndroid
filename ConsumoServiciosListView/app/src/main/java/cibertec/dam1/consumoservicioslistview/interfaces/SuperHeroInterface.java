package cibertec.dam1.consumoservicioslistview.interfaces;

import java.util.List;

import cibertec.dam1.consumoservicioslistview.modelo.Heroe;
import cibertec.dam1.consumoservicioslistview.modelo.ListaHeroes;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SuperHeroInterface {

    @GET("{character-id}")
    Call<Heroe> getHero(@Path("character-id") String id);

    @GET("search/{name}")
    Call<ListaHeroes> getListaHeroes(@Path("name") String nombre);

}
