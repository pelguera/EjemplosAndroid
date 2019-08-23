package com.uprade.milistview;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvLista;
    private List<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.llenarDatos();
        lvLista = findViewById(R.id.lvLista);
        //MyAdapter adapter = new MyAdapter(R.layout)

    }


    private void llenarDatos(){
        this.lista = new ArrayList<String>();

        this.lista.add("Paul Elguera");
        this.lista.add("Midori Namisato");
        this.lista.add("Jhon Mattos");
        this.lista.add("Jesus Vasquez");
        this.lista.add("Juan Espinoza");
        this.lista.add("Jessica Garro");


    }

}
