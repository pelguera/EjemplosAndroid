package pe.cibertec.ejemplogridviewpersonalizado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.cibertec.ejemplogridviewpersonalizado.adapters.MyAdapter;
import pe.cibertec.ejemplogridviewpersonalizado.modelos.Jugadores;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private GridView gvJugadores;
    private ArrayList<Jugadores> listaJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.llenarDatos();
        this.gvJugadores = (GridView) findViewById(R.id.gvJugadores);
        this.gvJugadores.setOnItemClickListener(this);

        MyAdapter adapter = new MyAdapter(this, R.layout.list_item, this.listaJugadores);
        this.gvJugadores.setAdapter(adapter);
    }

    private void llenarDatos(){

        this.listaJugadores = new ArrayList<Jugadores>();

        Jugadores jugador = new Jugadores("Lionel Messi", "Jugador Argentino, juega en el Barcelona de España", "messi", "Barcelona");
        this.listaJugadores.add(jugador);

        jugador = new Jugadores("Cristiano Ronaldo", "Jugador Portugues, juega en la Juventus de Italia", "cr7", "Juventus");
        this.listaJugadores.add(jugador);



        jugador = new Jugadores("Bono", "Cantante del grupo de rock Irlandes U2", "bono", "U2");
        this.listaJugadores.add(jugador);

        jugador = new Jugadores("James Rodriguez", "Jugador Colombiano, juega en el Bayer Munich", "james", "bayer Munich");
        this.listaJugadores.add(jugador);

        jugador = new Jugadores("Paolo Guerrero", "Jugador Peruano, juega en el Inter de Brasil", "paologuerrero", "Internacionale");
        this.listaJugadores.add(jugador);

        jugador = new Jugadores("Jennifer Love Hewitt", "Actriz norteamerica", "jenniferlove", "Hollywood");
        this.listaJugadores.add(jugador);

        jugador = new Jugadores("Mick Jagger", "Cantante del grupo de rock Rolling Stones", "mickjagger", "Rolling Stones");
        this.listaJugadores.add(jugador);

        jugador = new Jugadores("Pedro Suarez Vertiz", "Cantante y compositor Peruano", "pedrosuarez", "Arena Hash");
        this.listaJugadores.add(jugador);

        jugador = new Jugadores("Robert Downey Jr", "Actor norteamericano", "robertdowneyjr", "Hollywood");
        this.listaJugadores.add(jugador);

        jugador = new Jugadores("Sandra Bullock", "Actriz norteamericana", "sandrabullock", "Hollywood");
        this.listaJugadores.add(jugador);

        jugador = new Jugadores("Scarlett Johansson", "Actriz norteamericana", "scarlettjohansson", "Hollywood");
        this.listaJugadores.add(jugador);

        jugador = new Jugadores("Shakira", "Cantante Colombiana", "shakira", "Shakira");
        this.listaJugadores.add(jugador);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Jugadores jugador = this.listaJugadores.get(position);
        Toast.makeText(MainActivity.this, jugador.getNombre(), Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, DetalleJugadorActivity.class);
        i.putExtra("jugador", jugador);
        //i.putExtra("descripcion", jugador.getDescripcion());
        startActivity(i);
    }
}
