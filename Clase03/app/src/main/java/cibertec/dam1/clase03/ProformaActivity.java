package cibertec.dam1.clase03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProformaActivity extends AppCompatActivity {

    private TextView tvResulNombre;
    private TextView tvResulDireccion;
    private TextView tvResulDistrito;
    private TextView tvResulAuto;
    private TextView tvResulAplicaDscto;
    private TextView tvResulPrecioAuto;
    private TextView tvResulDsctoAuto;
    private TextView tvResulIgvAuto;
    private TextView tvResulSubTotalAuto;
    private TextView tvResulTotalAuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proforma);

        this.initComponentes();

        Bundle bundle = getIntent().getExtras();
        this.tvResulNombre.setText(bundle.getString("nombreCliente").toString());
        this.tvResulDireccion.setText(bundle.getString("direccionCliente").toString());
        this.tvResulDistrito.setText(bundle.getString("distritoCliente").toString());
        this.tvResulAuto.setText(bundle.getString("autoCliente").toString());
        this.tvResulPrecioAuto.setText(Double.toString(bundle.getDouble("precioAuto")));
        boolean dscto = bundle.getBoolean("aplicaDscto");
        if(dscto)
            this.tvResulAplicaDscto.setText("SI");
        else
            this.tvResulAplicaDscto.setText("NO");


    }

    private void initComponentes(){
        this.tvResulNombre = (TextView) findViewById(R.id.tvResulNombre);
        this.tvResulDireccion = (TextView) findViewById(R.id.tvResulDireccion);
        this.tvResulDistrito = (TextView) findViewById(R.id.tvResulDistrito);
        this.tvResulAuto = (TextView) findViewById(R.id.tvResulAuto);
        this.tvResulAplicaDscto = (TextView) findViewById(R.id.tvResulAplicaDscto);
        this.tvResulPrecioAuto = (TextView) findViewById(R.id.tvResulPrecio);
        this.tvResulDsctoAuto = (TextView) findViewById(R.id.tvResulDscto);
        this.tvResulIgvAuto = (TextView) findViewById(R.id.tvResulIGV);
        this.tvResulSubTotalAuto = (TextView) findViewById(R.id.tvResulSubTotal);
        this.tvResulTotalAuto = (TextView) findViewById(R.id.tvResulTotal);
    }
}
