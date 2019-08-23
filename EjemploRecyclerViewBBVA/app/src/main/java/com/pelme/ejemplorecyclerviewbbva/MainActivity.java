package com.pelme.ejemplorecyclerviewbbva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvListaElementos;
    private List<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //aca instancio el recyclerview
        rvListaElementos = findViewById(R.id.rvLista);
        //aca llamo al metodo para llenar datos en mi listado
        this.llenarDatos();
        //aca instancio al adapter
        ElementoAdapter adapter = new ElementoAdapter(R.layout.lista_item, contactos);
        rvListaElementos.setAdapter(adapter);
        rvListaElementos.setLayoutManager(new LinearLayoutManager(this));

    }


    private void llenarDatos(){

        this.contactos = new ArrayList<Contacto>(){
            {
              add(new Contacto("Pedro Suarez", R.mipmap.pedrosuarez));
              add(new Contacto("Shakira", R.mipmap.shakira));
              add(new Contacto("Robert Downey", R.mipmap.robertdowneyjr));
              add(new Contacto("Sandra Bullock", R.mipmap.sandrabullock));
              add(new Contacto("Scarlett Johansson", R.mipmap.scarlettjohansson));
            }
        };



    }

}
