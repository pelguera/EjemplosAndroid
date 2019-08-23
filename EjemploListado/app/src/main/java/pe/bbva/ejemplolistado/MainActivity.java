package pe.bbva.ejemplolistado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.bbva.ejemplolistado.adapters.ContactoAdapter;
import pe.bbva.ejemplolistado.modelo.Contacto;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvListado;
    private List<Contacto> listado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvListado = findViewById(R.id.lvContactos);
        llenarDatos();

        ContactoAdapter adapter = new ContactoAdapter(R.layout.item_lista,
                MainActivity.this, this.listado);

        this.lvListado.setAdapter(adapter);

        this.lvListado.setOnItemClickListener(this);
    }

    private void llenarDatos(){
        listado = new ArrayList<Contacto>();

        Contacto contacto = new Contacto("bono", "Cantante U2", R.mipmap.bono);
        listado.add(contacto);

        contacto = new Contacto("Cristiano Ronaldo", "Futbolista portugues", R.mipmap.cr7);
        listado.add(contacto);

        contacto = new Contacto("Shakira", "Cantante Colombiana", R.mipmap.shakira);
        listado.add(contacto);

        contacto = new Contacto("Pedro Suarez Vertiz", "Cantante Peruano", R.mipmap.pedrosuarez);
        listado.add(contacto);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(MainActivity.this,
                "Contacto seleccionado: " + this.listado.get(i).getNombre(),
                Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
        intent.putExtra("nombre", this.listado.get(i).getNombre());
        intent.putExtra("descripcion", this.listado.get(i).getDescripcion());
        intent.putExtra("foto", this.listado.get(i).getIdFoto());

        startActivity(intent);
    }
}
