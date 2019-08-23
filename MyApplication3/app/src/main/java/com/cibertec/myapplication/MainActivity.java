package com.cibertec.ejemplolistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cibertec.myapplication.Adapters.AdapterContacto;
import com.cibertec.myapplication.DetalleActivity;
import com.cibertec.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    private ListView lvListaContactos;
    private List<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvListaContactos = findViewById(R.id.lvListaContactos);
        //metodo para llenar la lista de contactos
        llenarContactos();
        //instancio el adapter
        AdapterContacto adapter = new AdapterContacto(this, R.layout.lista_contactos_item,
                contactos);
        //seteo el adapter al listview
        this.lvListaContactos.setAdapter(adapter);
        //Aca indico que el ListView va a llamar al evento ItemClick
        lvListaContactos.setOnItemClickListener(this);

    }


    private void llenarContactos(){

        contactos = new ArrayList<Contacto>();
        Contacto contacto = new Contacto();


        contactos.add(contacto);

        contacto = new Contacto("cr7",
                "Cristiano Ronaldo",
                "Futbolista Portugues",
                "4548545454", 30, "Av. Juventus");

        contactos.add(contacto);


        contacto = new Contacto("james",
                "James Rodriguez",
                "Futbolista Colombiano",
                "2574544555", 25, "Av. Colombia");

        contactos.add(contacto);

        contacto = new Contacto("jenniferlove",
                "Jennifer Love Hewitt",
                "Actriz Norteamericana",
                "98547855", 42, "Av. Hollywood");

        contactos.add(contacto);


        contacto = new Contacto("messi",
                "Lionel Messi",
                "Futbolista Argentino",
                "65981458", 33, "Av. Argentina");

        contactos.add(contacto);


        contacto = new Contacto("mickjagger",
                "Mick Jagger",
                "Cantante Grupo de Rock Rolling Stones",
                "87855855", 70, "Av. Gran Bretaña");

        contactos.add(contacto);



        contacto = new Contacto("paologuerrero",
                "Paolo Guerrero",
                "Futbolista Peruano",
                "54124892", 35, "Av. Peru");

        contactos.add(contacto);


        contacto = new Contacto("pedrosuarez",
                "Pedro Suarez Vertiz",
                "Cantante Peruano",
                "54894555", 45, "Av. Peru");

        contactos.add(contacto);


        contacto = new Contacto("robertdowneyjr",
                "Robert Downey Jr",
                "Actor Norteamericano",
                "36984755", 45, "Av. Hollywood");

        contactos.add(contacto);


        contacto = new Contacto("sandrabullock",
                "Sandra Bullock",
                "Actriz Norteamericana",
                "965888554", 50, "Av. Hollywood");

        contactos.add(contacto);


        contacto = new Contacto("scarlettjohansson",
                "Scarlet Johansson",
                "Actriz Norteamericana",
                "8597465688", 33, "Av. Hollywood");

        contactos.add(contacto);


        contacto = new Contacto("shakira",
                "Shakira",
                "Cantante Colombiana",
                "95884755", 39, "Av. Colombia");

        contactos.add(contacto);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Contacto contacto = this.contactos.get(position);
        Toast.makeText(MainActivity.this,
                contacto.getNombreProducto(), Toast.LENGTH_LONG).show();


        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
        intent.putExtra("miContacto", contacto);
        startActivity(intent);



    }
}



