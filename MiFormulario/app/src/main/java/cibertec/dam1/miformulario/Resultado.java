package cibertec.dam1.miformulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private TextView tvResultadoCliente;
    private TextView tvResultadoDistrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        this.tvResultadoCliente = (TextView) findViewById(R.id.tvResultadoCliente);
        this.tvResultadoDistrito = (TextView) findViewById(R.id.tvResultadoDistrito);

        Bundle bundle = getIntent().getExtras();

        this.tvResultadoCliente.setText(bundle.getString("nombreCliente"));
        this.tvResultadoDistrito.setText(bundle.getString("distritoCliente"));

    }
}
