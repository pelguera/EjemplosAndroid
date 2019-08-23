package cibertec.dam1.t5bmclase13.interfaces;

import cibertec.dam1.t5bmclase13.modelo.Heroe;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SuperHeroeInterface {

    @GET("{character-id}")
    Call<Heroe> getHeroe(@Path("character-id") String id);

}
