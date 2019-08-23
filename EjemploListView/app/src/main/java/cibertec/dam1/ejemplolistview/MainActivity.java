package cibertec.dam1.ejemplolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import cibertec.dam1.ejemplolistview.adapters.ElementoAdaptador;
import cibertec.dam1.ejemplolistview.model.Elemento;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<Elemento> elementos = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recuperamos el ListView
        ListView listViewElementos = (ListView)findViewById(R.id.listViewElementos);

        //
        elementos = getElementos();
        //iniciamos el adaptador
        ElementoAdaptador adaptador = new ElementoAdaptador(this, getElementos());
        //asociamos el adaptador a la vista
        listViewElementos.setAdapter(adaptador);
        //registramos el evento onClick
        listViewElementos.setOnItemClickListener(this);
    }

    public ArrayList<Elemento> getElementos(){
        ArrayList<Elemento> elementos = new ArrayList<Elemento>();
        elementos.add(new Elemento(1, "Manzana", "manzana"));
        elementos.add(new Elemento(2, "Kiwi", "kiwi"));
        elementos.add(new Elemento(3, "Pera", "pera"));
        return elementos;
    }

    @Override
    public void onItemClick(AdapterView<?> padre, View vista, int posicion, long id) {
        //Recuperamos el elemento de la posicion indicada
        Elemento elementoSeleccionado = elementos.get(posicion);
        //armamos el mensaje
        String mensaje = "Has seleccionado el elemento " + elementoSeleccionado.getNombre() +
                " ubicado en la posición " + posicion;
        //enviamos la notificacion
        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();

    }
}
