package pe.bbva.ejemplolistado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Bundle bundle = getIntent().getExtras();

        Log.d("DetalleActivity", bundle.getString("nombre"));

    }
}
