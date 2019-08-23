package pe.bbva.tallerbasicoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tvNombreCliente;
    private TextView tvDireccionCliente;
    private TextView tvMarcaAuto;
    private TextView tvModeloAuto;
    private TextView tvPrecioAuto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvNombreCliente = findViewById(R.id.tvNombreCliente);
        tvDireccionCliente = findViewById(R.id.tvDireccionCliente);
        tvMarcaAuto = findViewById(R.id.tvMarcaAuto);
        tvModeloAuto = findViewById(R.id.tvModeloAuto);
        tvPrecioAuto = findViewById(R.id.tvPrecioAuto);

        Bundle bundle = getIntent().getExtras();

        this.tvNombreCliente.setText(bundle.getString("nombre"));
        this.tvDireccionCliente.setText(bundle.getString("direccion"));
        this.tvMarcaAuto.setText(bundle.getString("marca"));
        this.tvModeloAuto.setText(bundle.getString("modelo"));
        this.tvPrecioAuto.setText(bundle.getString("precioAuto"));

    }
}
