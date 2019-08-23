package cibertec.dam1.lp01_t5am;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import cibertec.dam1.lp01_t5am.adapters.MyAdapter;
import cibertec.dam1.lp01_t5am.modelo.Productos;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private ArrayList<Productos>listaProductos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.llenadatos();
        this.lista=(ListView) findViewById(R.id.lvLista);

        MyAdapter adapter= new MyAdapter(context:this R.layout.List_item,this.listaProductos);

    }

    private void llenadatos(){


        this.listaProductos= new ArrayList<Productos>();
        Productos producto= new Productos(nombre:"fresa",precio:"S/15");
                this.listaProductos.add(producto);
        Productos producto= new Productos(nombre:"galleta",precio:"S/15");
                 this.listaProductos.add(producto);
        Productos producto= new Productos(nombre:"gaseosa",precio:"S/15");
        this.listaProductos.add(producto);
        Productos producto= new Productos(nombre:"leche",precio:"S/15");
        this.listaProductos.add(producto);
        Productos producto= new Productos(nombre:"papaya",precio:"S/15");
        this.listaProductos.add(producto);


    }



}
