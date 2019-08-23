package com.pelme.ejemplocardrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.pelme.ejemplocardrecyclerview.modelo.Pelicula;

public class AgregarPeliculaActivity extends AppCompatActivity {

    private TextInputEditText etTitulo, etTipo, etDuracion;
    private Spinner spPelicula;
    private Toolbar myToolbar;
    private Pelicula pelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_pelicula);

        initUI();

    }

    private void initUI(){
        myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        etTipo = findViewById(R.id.etTipoPelicula);
        etDuracion = findViewById(R.id.etDuracionPelicula);
        spPelicula = findViewById(R.id.spPelicula);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_nueva_pelicula, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuGrabarPelicula:
                this.obtenerDatos();
                Intent intent = new Intent();
                intent.putExtra("nuevaPelicula", this.pelicula);
                setResult(MainActivity.INT_RPTA, intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void obtenerDatos(){

        String nombre = "";
        int idFoto = 0;

        switch(spPelicula.getSelectedItemPosition()){
            case 1:
                nombre = "Aladdin";
                idFoto = R.mipmap.aladdin;
                break;
            case 2:
                nombre = "Bohemia Rhapsody";
                idFoto = R.mipmap.bohemianrhapsody;
                break;
            case 3:
                nombre = "Captain Marvel";
                idFoto = R.mipmap.captainmarvel;
                break;
            case 4:
                nombre = "Dumbo";
                idFoto = R.mipmap.dumbo;
                break;
            case 5:
                nombre = "Avengers Endgame";
                idFoto = R.mipmap.endgame;
                break;
            case 6:
                nombre = "Fast and Furious 8";
                idFoto = R.mipmap.fastandfurious8;
                break;
            case 7:
                nombre = "Glass";
                idFoto = R.mipmap.glass;
                break;
            case 8:
                nombre = "Avengers Infinity war";
                idFoto = R.mipmap.infinitywar;
                break;
            case 9:
                nombre = "El Rey Leon";
                idFoto = R.mipmap.reyleon;
                break;
            case 10:
                nombre = "Spiderman Homecoming";
                idFoto = R.mipmap.spidermanhomecoming;
                break;
            case 11:
                nombre = "Spiderman far from home";
                idFoto = R.mipmap.spidermanfarfromhome;
                break;
            case 12:
                nombre = "Toy Story 4";
                idFoto = R.mipmap.toystory4;
                break;
        }

        this.pelicula = new Pelicula(nombre, idFoto, this.etDuracion.getText().toString(), this.etDuracion.getText().toString());


    }
}
