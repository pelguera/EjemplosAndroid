package cibertec.dam1.getdog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActivityInformacion extends AppCompatActivity {

    private TextView tvNombre,tvGenero,tvRaza,tvTamano,tvColor,tvFecha,tvEstado,tvDireccion,tvDescripcion;
    private CircleImageView cirFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        this.tvNombre=findViewById(R.id.tvNombreMascota);
        this.tvGenero=findViewById(R.id.tvGeneroMascota);
        this.tvRaza=findViewById(R.id.tvRazaMascota);
        this.tvTamano=findViewById(R.id.tvTamanoMascota);
        this.tvColor=findViewById(R.id.tvColorMascota);
        this.tvFecha=findViewById(R.id.tvFechaMascota);
        this.tvEstado=findViewById(R.id.tvEstadoMascota);
        this.tvDireccion=findViewById(R.id.tvDireccionMascota);
        this.tvDescripcion=findViewById(R.id.tvDescripcionMascota);
        this.cirFoto=findViewById(R.id.civFoto);

        Bundle bundle=getIntent().getExtras();
        String nombre=bundle.getString("nombre");
        String genero=bundle.getString("genero");
        String raza=bundle.getString("raza");
        String tamaño=bundle.getString("tamaño");
        String color=bundle.getString("color");
        String fecha=bundle.getString("fecha");
        String estado=bundle.getString("estado");
        String direccion=bundle.getString("direccion");
        String descripcion=bundle.getString("descripcion");
        String nombreFoto=bundle.getString("foto");

        int icono=this.getResources().getIdentifier(nombreFoto,"mipmap",getPackageName());
        cirFoto.setImageResource(icono);
/*
        this.tvNombre.setText(nombre);
        this.tvGenero.setText(genero);
        this.tvRaza.setText(raza);
        this.tvTamano.setText(tamaño);
        this.tvColor.setText(color);
        this.tvFecha.setText(fecha);
        this.tvEstado.setText(estado);
        this.tvDireccion.setText(direccion);
        this.tvDescripcion.setText(descripcion);
*/
    }
}
