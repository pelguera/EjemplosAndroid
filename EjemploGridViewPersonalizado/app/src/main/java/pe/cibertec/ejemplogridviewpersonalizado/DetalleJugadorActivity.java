package pe.cibertec.ejemplogridviewpersonalizado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import pe.cibertec.ejemplogridviewpersonalizado.modelos.Jugadores;

public class DetalleJugadorActivity extends AppCompatActivity {

    private ImageView ivFoto;
    private TextView tvNombre, tvEquipo, tvDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_jugador);
        inicializarUI();
        Jugadores jugador = (Jugadores) getIntent().getSerializableExtra("jugador");
        cargarUI(jugador);

    }

    private void cargarUI(Jugadores jugador) {

        tvNombre.setText(jugador.getNombre());
        tvEquipo.setText(jugador.getNombreEquipo());
        tvDescripcion.setText(jugador.getDescripcion());

        int iconoFoto = getResources().getIdentifier(jugador.getNombreFoto(), "mipmap", getPackageName());
        ivFoto.setImageResource(iconoFoto);
    }

    private void inicializarUI(){
        ivFoto = findViewById(R.id.ivFoto);
        tvNombre = findViewById(R.id.tvNombre);
        tvEquipo = findViewById(R.id.tvEquipo);
        tvDescripcion = findViewById(R.id.tvDescripcion);

    }
}
