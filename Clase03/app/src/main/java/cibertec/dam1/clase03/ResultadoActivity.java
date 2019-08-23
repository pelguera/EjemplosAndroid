package cibertec.dam1.clase03;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tvResulNombre;
    private TextView tvResulDireccion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado_activity);

        this.initComponentes();

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombreCliente");
        this.tvResulNombre.setText(nombre);
        this.tvResulDireccion.setText(bundle.getString("direccionCliente").toString());

    }


    private void initComponentes(){
        this.tvResulNombre = (TextView) findViewById(R.id.tvResulNombre);
        this.tvResulDireccion = (TextView) findViewById(R.id.tvResulDireccion);
    }
}
