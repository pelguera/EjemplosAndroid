package cibertec.dam1.lp01_t5bm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import cibertec.dam1.lp01_t5bm.adapter.MyAdapter;
import cibertec.dam1.lp01_t5bm.modelo.Empleado;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lista;
    private ArrayList<Empleado> listaEmpleados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.llenarDatos();
        this.lista = (ListView) findViewById(R.id.lvLista);
        this.lista.setOnItemClickListener(this);

        MyAdapter adapter = new MyAdapter(this, R.layout.list_item, this.listaEmpleados);
        this.lista.setAdapter(adapter);
    }

    private void llenarDatos(){

        this.listaEmpleados = new ArrayList<Empleado>();

        Empleado empleado = new Empleado("Id01","kiyoshi","Kiyoshi ",
                "Fujino","Hombre","Carcel1","1","987123456","kyF@gmail.com");
        this.listaEmpleados.add(empleado);

        empleado = new Empleado("Id02","takehito","Takehito",
                "Morokuzu","Hombre","Carcel2","1","987162356","taM@gmail.com");
        this.listaEmpleados.add(empleado);

        empleado = new Empleado("Id03","shingo","Shingo",
                "Wakamoto","Hombre","Carcel3","1","987927456","ShiW@gmail.com");
        this.listaEmpleados.add(empleado);

        empleado = new Empleado("Id04","jou","Jouji",
                "Nezu","Hombre","Carcel4","1","987961456","JoN@gmail.com");
        this.listaEmpleados.add(empleado);

        empleado = new Empleado("Id05","reiji","Reiji",
                "Andou","Hombre","Carcel5","1","293123456","ReA@gmail.com");
        this.listaEmpleados.add(empleado);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Empleado empleado = this.listaEmpleados.get(position);
        Toast.makeText(MainActivity.this, empleado.getId(), Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, DetalleActivity.class);
        i.putExtra("nombre", empleado.getNombres());
        i.putExtra("apellido", empleado.getApellidos());
        i.putExtra("sexo", empleado.getSexo());
        i.putExtra("documento", empleado.getDocumento());
        i.putExtra("nroD", empleado.getNroDocumento());
        i.putExtra("telefono", empleado.getTelefono());
        i.putExtra("email", empleado.getEmail());


        startActivity(i);
    }

}
