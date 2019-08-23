package cibertec.dam1.getdog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import cibertec.dam1.getdog.Adapters.AdapterMascota;
import cibertec.dam1.getdog.Modelo.Mascotas;

public class ActivityItems extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lista;
    private ArrayList<Mascotas> ListaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        this.llenarDatos();
        this.lista=(ListView) findViewById(R.id.lvListado);
        this.lista.setOnItemClickListener(this);

        AdapterMascota adapterMascota =new AdapterMascota(this,R.layout.list_item,this.ListaMascotas);
        this.lista.setAdapter(adapterMascota);
    }

    private void llenarDatos(){
        this.ListaMascotas=new ArrayList<Mascotas>();
        Mascotas m=new Mascotas("Coco",
                "Coco fué rescatado, ya está listo para encontrar un hogar lleno de amor y cariño, tine aproximadamente dos años.",
                "Macho",
                "Cruce",
                "Mediano",
                "Blanco, negro y marrón",
                "Av. Miguel Isglesias 452, SJM.",
                "Adopción",
                "23/06/19",
                "i0001");
        this.ListaMascotas.add(m);

        m= new Mascotas("Orejas",
                "Es lamentable darlo en adopción pero mi situción económica no es la mejor y el necesita muchisimo cuidado.",
                "Macho",
                "Cruce",
                "Mediano",
                "Blanco y marrón",
                "Av. San Juan 358, SJM.",
                "Adopción",
                "19/06/19",
                "i0002");
        this.ListaMascotas.add(m);

        m= new Mascotas("Nina",
                "Se me perdió esta mañana cuando salí a trabajar, me preocupa porque está cojeando de su pata izquierda.",
                "Hembra",
                "Cruce",
                "Pequeño",
                "Blanco y marrón",
                "Caminos del Inca 192, Surco",
                "Perdido",
                "20/06/19",
                "i0003");
        this.ListaMascotas.add(m);

        m= new Mascotas("Rayi",
                "Por favor si logran encontrarlo avísenme lo más pronto posible ya que está operada y tiene que continuar con su tratamiento.",
                "Macho",
                "Siamés",
                "Mediano",
                "Blanco y  marrón oscuro",
                "Av. República Panamá 685, Miraflores",
                "Perdido",
                "23/06/19",
                "i0004");
        this.ListaMascotas.add(m);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Mascotas mascota=this.ListaMascotas.get(position);

        Intent i=new Intent(this, ActivityInformacion.class);
        i.putExtra("nombre",mascota.getNombre());
        i.putExtra("genero",mascota.getGenero());
        i.putExtra("raza",mascota.getRaza());
        i.putExtra("tamaño",mascota.getTamaño());
        i.putExtra("color",mascota.getColor());
        i.putExtra("fecha",mascota.getFecha());
        i.putExtra("estado",mascota.getEstado());
        i.putExtra("direccion",mascota.getDireccion());
        i.putExtra("descripcion",mascota.getDescripcion());
        i.putExtra("foto",mascota.getNombreFoto());

        startActivity(i);

    }
}
