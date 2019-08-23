package cibertec.dam1.t5am_clase06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lista;
    private ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.llenarDatos();
        this.lista = (ListView) findViewById(R.id.lvLista);

        MyAdapter adaptador = new MyAdapter(this, R.layout.list_item, this.contactos);
        this.lista.setAdapter(adaptador);
        this.lista.setOnItemClickListener(this);

    }


    private void llenarDatos(){
        contactos = new ArrayList<Contacto>();

        Contacto contacto = new Contacto("Lionel Messi", "Entrenando en el barca", "messi");
        contactos.add(contacto);

        contacto = new Contacto("Cristiano Ronaldo", "posando pa la foto", "cr7");
        contactos.add(contacto);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Contacto contacto = this.contactos.get(position);
        Toast.makeText(MainActivity.this, contacto.getNombre(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
        intent.putExtra("nombre", contacto.getNombre());
        intent.putExtra("estado", contacto.getEstado());
        intent.putExtra("foto", contacto.getNombreFoto());

        startActivity(intent);

    }


}
