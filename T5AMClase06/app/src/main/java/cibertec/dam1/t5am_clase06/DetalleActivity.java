package cibertec.dam1.t5am_clase06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    private ImageView ivDetalleFoto;
    private TextView tvDetalleNombre, tvDetalleEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        this.ivDetalleFoto = (ImageView) findViewById(R.id.ivDetalleFoto);
        this.tvDetalleNombre = (TextView) findViewById(R.id.tvDetalleNombre);
        this.tvDetalleEstado = (TextView) findViewById(R.id.tvDetalleEstado);

        Bundle bundle = getIntent().getExtras();

        this.tvDetalleNombre.setText(bundle.getString("nombre"));
        this.tvDetalleEstado.setText(bundle.getString("estado"));

        int idFoto = this.getResources().getIdentifier(bundle.getString("foto"), "mipmap", getPackageName());
        this.ivDetalleFoto.setImageResource(idFoto);

    }
}
