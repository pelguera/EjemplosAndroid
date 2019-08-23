package com.pelme.ejemplorecyclerviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.pelme.ejemplorecyclerviewpersonalizado.adapters.ContactoAdapter;
import com.pelme.ejemplorecyclerviewpersonalizado.modelo.Contactos;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private RecyclerView rvListaContactos;
    private RecyclerView.LayoutManager layoutManager;
    private List<Contactos> listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llenarDatos();

        rvListaContactos = findViewById(R.id.rvListaContactos);
        layoutManager = new LinearLayoutManager(this);
        ContactoAdapter adapter = new ContactoAdapter(R.layout.recycler_list_item, listaContactos, new ContactoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Contactos contacto, int position) {
                Toast.makeText(MainActivity.this, "Contacto seleccionado: " + contacto.getNombre(), Toast.LENGTH_LONG).show();
            }
        });

        rvListaContactos.setLayoutManager(layoutManager);
        rvListaContactos.setAdapter(adapter);

    }


    private void llenarDatos(){

        this.listaContactos = new ArrayList<Contactos>();

        Contactos contacto = new Contactos("Lionel Messi", "Jugador Argentino, juega en el Barcelona de España", R.mipmap.messi, "8373882992", 34, "Av Argentina");
        this.listaContactos.add(contacto);

        contacto = new Contactos("Cristiano Ronaldo", "Jugador Portugues, juega en la Juventus de Italia", R.mipmap.cr7, "889292929", 30, "Av. Portugal");
        this.listaContactos.add(contacto);

        contacto = new Contactos("Bono", "Cantante del grupo de rock Irlandes U2", R.mipmap.bono, "736838292", 60, "Av Irlanda");
        this.listaContactos.add(contacto);

        contacto = new Contactos("James Rodriguez", "Jugador Colombiano, juega en el Bayer Munich", R.mipmap.james, "827292929", 26, "Av. Colombia");
        this.listaContactos.add(contacto);

        contacto = new Contactos("Paolo Guerrero", "Jugador Peruano, juega en el Inter de Brasil", R.mipmap.paologuerrero, "847389022", 36, "Av. Peru");
        this.listaContactos.add(contacto);

        contacto = new Contactos("Jennifer Love Hewitt", "Actriz norteamerica", R.mipmap.jenniferlove, "9387283747", 45, "Av. Hollywood");
        this.listaContactos.add(contacto);

        contacto = new Contactos("Mick Jagger", "Cantante del grupo de rock Rolling Stones", R.mipmap.mickjagger, "5647839393", 70, "Av Gran Bretaña");
        this.listaContactos.add(contacto);

        contacto = new Contactos("Pedro Suarez Vertiz", "Cantante y compositor Peruano", R.mipmap.pedrosuarez, "465839383", 50, "Av Arena Hash");
        this.listaContactos.add(contacto);

        contacto = new Contactos("Robert Downey Jr", "Actor norteamericano", R.mipmap.robertdowneyjr, "78738221", 45, "Av. Hollywood");
        this.listaContactos.add(contacto);

        contacto = new Contactos("Sandra Bullock", "Actriz norteamericana", R.mipmap.sandrabullock, "938383929", 45, "Av. Hollywood");
        this.listaContactos.add(contacto);

        contacto = new Contactos("Scarlett Johansson", "Actriz norteamericana", R.mipmap.scarlettjohansson, "563393939", 38, "Av. Hollywood");
        this.listaContactos.add(contacto);

        contacto = new Contactos("Shakira", "Cantante Colombiana", R.mipmap.shakira, "347382920", 38, "Av. Colombia");
        this.listaContactos.add(contacto);

    }

}
