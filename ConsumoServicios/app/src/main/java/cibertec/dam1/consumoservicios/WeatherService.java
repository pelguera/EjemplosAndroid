package cibertec.dam1.consumoservicios;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("weather")
    Call<Ciudad> getCiudad(@Query("q") String ciudad, @Query("appid") String key);

}
