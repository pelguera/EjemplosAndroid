package com.pelme.ejemplocardrecyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.pelme.ejemplocardrecyclerview.adapters.PeliculaAdapter;
import com.pelme.ejemplocardrecyclerview.modelo.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPeliculas;
    private List<Pelicula> peliculas;
    private Toolbar myToolbar;
    private PeliculaAdapter adapter;
    public static final int INT_RPTA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.llenarDatos();

        myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        rvPeliculas = findViewById(R.id.rvListaPeliculas);
        this.adapter = new PeliculaAdapter(R.layout.card_view_item, this.peliculas, new PeliculaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Pelicula pelicula, int position) {
                Toast.makeText(MainActivity.this, "Card seleccionado: " + pelicula.getNombre(), Toast.LENGTH_LONG).show();
            }
        });
        rvPeliculas.setLayoutManager(new LinearLayoutManager(this));
        rvPeliculas.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuAgregar:
                Intent intent = new Intent(MainActivity.this, AgregarPeliculaActivity.class);
                startActivityForResult(intent, INT_RPTA);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == INT_RPTA){
            Pelicula pelicula = (Pelicula) data.getSerializableExtra("nuevaPelicula");
            this.peliculas.add(pelicula);
            this.adapter.notifyDataSetChanged();
        }
    }

    private void llenarDatos(){
        this.peliculas = new ArrayList<Pelicula>();

        Pelicula pelicula = new Pelicula("Aladino", R.mipmap.aladdin, "Comedia", "2:14");
        this.peliculas.add(pelicula);

        pelicula = new Pelicula("Avengers Infinity war", R.mipmap.infinitywar, "Accion", "2:54");
        this.peliculas.add(pelicula);

        pelicula = new Pelicula("Dumbo", R.mipmap.dumbo, "Comedia", "1:48");
        this.peliculas.add(pelicula);

        pelicula = new Pelicula("Glass", R.mipmap.glass, "Accion - Suspenso", "2:23");
        this.peliculas.add(pelicula);

    }
}
