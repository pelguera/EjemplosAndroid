package com.pelme.fragmentsdinamicos.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pelme.fragmentsdinamicos.R;
import com.pelme.fragmentsdinamicos.fragments.DetalleFragment;
import com.pelme.fragmentsdinamicos.modelo.Pelicula;

public class DetalleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Pelicula pelicula = (Pelicula) getIntent().getSerializableExtra("pelicula");

        DetalleFragment detalleFragment = (DetalleFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetalle);
        detalleFragment.renderizarPelicula(pelicula);
    }
}
