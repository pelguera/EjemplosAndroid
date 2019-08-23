package cibertec.dam1.examenfinal.interfaces;

import java.util.List;

import cibertec.dam1.examenfinal.modelo.Heroe;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SuperHeroInterface {

    @GET("{character-id}")
    Call<Heroe> getHero(@Path("character-id") String id);

}
