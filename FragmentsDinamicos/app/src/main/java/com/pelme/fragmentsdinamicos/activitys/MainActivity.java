package com.pelme.fragmentsdinamicos.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.pelme.fragmentsdinamicos.R;
import com.pelme.fragmentsdinamicos.fragments.DetalleFragment;
import com.pelme.fragmentsdinamicos.fragments.ListaFragment;
import com.pelme.fragmentsdinamicos.modelo.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListaFragment.OnFragmentInteractionListener {

    private boolean horizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setHorizontal();
    }


    @Override
    public void onListClick(Pelicula pelicula) {

        if(horizontal){
            DetalleFragment detalleFragment = (DetalleFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetalle);
            detalleFragment.renderizarPelicula(pelicula);

        }else{
            Intent intent = new Intent(this, DetalleActivity.class);
            intent.putExtra("pelicula", pelicula);
            startActivity(intent);
        }


    }

    private void setHorizontal(){
        this.horizontal = (getSupportFragmentManager().findFragmentById(R.id.fragmentDetalle) != null);
    }
}
