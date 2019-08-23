package com.cibertec.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class DetalleActivity extends AppCompatActivity {

    private TextView tvDetalleNombre;
    private TextView tvDetalleTipo;
    private TextView tvDetalleStock;
    private TextView tvDetallePrecio;
    private ImageView ivDetalleFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        this.inicializarUI();

        Contacto contacto = (Contacto)
                                getIntent().getSerializableExtra("miContacto");
        cargarUI(contacto);

    }

    private void inicializarUI(){
        this.tvDetalleNombre = findViewById(R.id.tvDetalleNombre);
        this.tvDetalleTipo = findViewById(R.id.tvDetalleTipo);
        this.tvDetalleStock = findViewById(R.id.tvDetalleStock);
        this.tvDetallePrecio = findViewById(R.id.tvDetallePrecio);
        this.ivDetalleFoto = findViewById(R.id.ivDetalleFoto);
    }

    private void cargarUI(Contacto contacto){
        this.tvDetalleNombre.setText(contacto.getNombreProducto());
        this.tvDetalleTipo.setText(contacto.getTipo());
        this.tvDetalleStock.setText(contacto.getStock() + "");
        this.tvDetallePrecio.setText(contacto.getPrecio());

        int icono = getResources()
                .getIdentifier(contacto.getNombreFoto(), "mipmap",
                        getPackageName());
        this.ivDetalleFoto.setImageResource(icono);

    }

}






