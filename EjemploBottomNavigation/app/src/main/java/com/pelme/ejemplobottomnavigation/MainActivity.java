package com.pelme.ejemplobottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pelme.ejemplobottomnavigation.fragments.ListadoFragment;
import com.pelme.ejemplobottomnavigation.fragments.BuscarFragment;
import com.pelme.ejemplobottomnavigation.fragments.NuevoFragment;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView btvMenuPrincipal;
    private FrameLayout flContenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btvMenuPrincipal = (BottomNavigationView) findViewById(R.id.btvMenu);
        btvMenuPrincipal.setOnNavigationItemSelectedListener(this);
        flContenido = (FrameLayout) findViewById(R.id.flContenido);

        getSupportFragmentManager().beginTransaction().replace(R.id.flContenido, new NuevoFragment()).commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        String opcSeleccionada = "";
        Fragment fgmMostrar = null;
        switch (menuItem.getItemId()){

            case R.id.navNuevo:
                fgmMostrar = new NuevoFragment();
                break;

            case R.id.navListado:
                fgmMostrar = new ListadoFragment();
                break;

            case R.id.navBuscar:
                fgmMostrar = new BuscarFragment();
                break;

        }
        getSupportFragmentManager().beginTransaction().replace(R.id.flContenido, fgmMostrar).commit();
        return true;
    }


}
