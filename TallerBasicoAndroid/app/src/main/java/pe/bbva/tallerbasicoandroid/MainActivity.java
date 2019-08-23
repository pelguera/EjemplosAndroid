package pe.bbva.tallerbasicoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private EditText etNombreCliente;
    private EditText etDireccionCliente;
    private EditText etMarcaAuto;
    private EditText etModeloAuto;
    private EditText etPrecioAuto;
    private Button btComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etNombreCliente = findViewById(R.id.etNombre);
        this.etDireccionCliente = findViewById(R.id.etDireccion);
        etMarcaAuto = findViewById(R.id.etMarca);
        etModeloAuto = findViewById(R.id.etModelo);
        etPrecioAuto = findViewById(R.id.etPrecio);
        btComprar = findViewById(R.id.btComprar);

        btComprar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String nombre = this.etNombreCliente.getText().toString();
        String direccion = this.etDireccionCliente.getText().toString();
        String marca = this.etMarcaAuto.getText().toString();
        String modelo = this.etModeloAuto.getText().toString();
        String precio = this.etPrecioAuto.getText().toString();

        Intent intent = new Intent(
                MainActivity.this,
                ResultadoActivity.class);

        intent.putExtra("nombre", nombre);
        intent.putExtra("direccion", direccion);
        intent.putExtra("marca", marca);
        intent.putExtra("modelo", modelo);
        intent.putExtra("precioAuto", precio);

        startActivity(intent);

    }
}
