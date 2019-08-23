package cibertec.dam1.el01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    private TextView dni;
    private TextView cliente;
    private TextView direccion;
    private TextView auto;
    private TextView precio;
    private TextView descuento;
    private TextView pagar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        this.dni = (TextView) findViewById(R.id.dni);
        this.cliente = (TextView) findViewById(R.id.cliente);
        this.direccion = (TextView) findViewById(R.id.direccion);
        this.auto = (TextView) findViewById(R.id.auto);
        this.precio = (TextView) findViewById(R.id.precio);
        this.descuento = (TextView) findViewById(R.id.descuento);
        this.pagar = (TextView) findViewById(R.id.pagar);

        Bundle bundle = getIntent().getExtras();

        this.dni.setText(bundle.getString("dni"));
        this.cliente.setText(bundle.getString("Cliente"));
        this.direccion.setText(bundle.getString("direccion"));
        this.auto.setText(bundle.getString("auto"));
        this.precio.setText(bundle.getString("precio"));
        this.descuento.setText(bundle.getString("descuento"));
        this.pagar.setText(bundle.getString("pagar"));

        this.dni.setText(dni);
        this.cliente.setText(cliente);
        this.direccion.setText(direccion);
        this.auto.setText(auto);
        this.precio.setText(String.valueOf(precio));
        this.pagar.setText(String.valueOf(pagar));
    }
}
