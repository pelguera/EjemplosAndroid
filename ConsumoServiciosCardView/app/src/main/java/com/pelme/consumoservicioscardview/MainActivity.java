package com.pelme.consumoservicioscardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pelme.consumoservicioscardview.adapters.SuperHeroAdapter;
import com.pelme.consumoservicioscardview.interfaces.SuperHeroInterface;
import com.pelme.consumoservicioscardview.modelo.Heroe;
import com.pelme.consumoservicioscardview.modelo.ListaHeroes;
import com.pelme.consumoservicioscardview.utils.Constantes;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView etNombreSuperHeroe;
    private RecyclerView rvLista;
    private Button btnBuscar;
    private List<Heroe> heroes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etNombreSuperHeroe = findViewById(R.id.etBusquedaSuperHero);
        this.btnBuscar = findViewById(R.id.btnBuscar);
        this.btnBuscar.setOnClickListener(this);
        this.rvLista = findViewById(R.id.rvLista);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnBuscar){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constantes.BASE_URL + Constantes.SUPERHERO_TOKEN + "/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            SuperHeroInterface service =retrofit.create(SuperHeroInterface.class);
            Call<ListaHeroes> listaHeroesCall = service.getListaHeroes(this.etNombreSuperHeroe.getText().toString());

            listaHeroesCall.enqueue(new Callback<ListaHeroes>() {
                @Override
                public void onResponse(Call<ListaHeroes> call, Response<ListaHeroes> response) {

                    ListaHeroes lista = response.body();
                    heroes = lista.getListaHeroes();

                    SuperHeroAdapter adapter = new SuperHeroAdapter(R.layout.item_superheroe, heroes);
                    rvLista.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rvLista.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<ListaHeroes> call, Throwable t) {

                }
            });

        }

    }
}
