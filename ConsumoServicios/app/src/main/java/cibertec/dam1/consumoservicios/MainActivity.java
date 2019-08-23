package cibertec.dam1.consumoservicios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);
        Call<Ciudad> callCiudad =  service.getCiudad("London,uk", "d66a1e6e75ccc1db44d234e4a29be8d1");

        callCiudad.enqueue(new Callback<Ciudad>() {
            @Override
            public void onResponse(Call<Ciudad> call, Response<Ciudad> response) {
                Ciudad ciudad = response.body();
                System.out.println(ciudad.getName());
                Toast.makeText(MainActivity.this, "Bien", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Ciudad> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });

    }
}
