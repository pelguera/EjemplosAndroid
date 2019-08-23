package cibertec.dam1.consumoservicioslistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cibertec.dam1.consumoservicioslistview.adapters.SuperHeroAdapter;
import cibertec.dam1.consumoservicioslistview.interfaces.SuperHeroInterface;
import cibertec.dam1.consumoservicioslistview.modelo.Heroe;
import cibertec.dam1.consumoservicioslistview.modelo.ListaHeroes;
import cibertec.dam1.consumoservicioslistview.utils.Constantes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText etCodigo;
    private Button btnBuscar;
    private ListView lvListaSuperHeroes;

    List<Heroe> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etCodigo = findViewById(R.id.etCodigoHeroe);
        this.btnBuscar = findViewById(R.id.btnBuscar);
        this.lvListaSuperHeroes = findViewById(R.id.lvListaSuperHeroes);
        this.btnBuscar.setOnClickListener(this);
        this.lvListaSuperHeroes.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnBuscar){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constantes.BASE_URL + Constantes.SUPERHERO_TOKEN + "/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            SuperHeroInterface service = retrofit.create(SuperHeroInterface.class);
            final Call<ListaHeroes> listaHeroes = service.getListaHeroes(this.etCodigo.getText().toString());

            listaHeroes.enqueue(new Callback<ListaHeroes>() {
                @Override
                public void onResponse(Call<ListaHeroes> call, Response<ListaHeroes> response) {
                    ListaHeroes lista = response.body();
                    heroes = lista.getListaHeroes();

                    SuperHeroAdapter adapter = new SuperHeroAdapter(MainActivity.this, R.layout.item_superheroe, heroes);
                    lvListaSuperHeroes.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<ListaHeroes> call, Throwable t) {

                }
            });



        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("MainActivity", "Posicion seleccionada: " + position);
    }
}
