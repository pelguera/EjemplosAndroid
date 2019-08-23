package cibertec.dam1.el02t5bm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetalleAlumno extends AppCompatActivity {

    private EditText etNombre,etApellido,etGrado,etNivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_alumno);
        etNombre= findViewById(R.id.etNombre);
        etApellido=findViewById(R.id.etApellido);
        etGrado=findViewById(R.id.etGrado);
        etNivel=findViewById(R.id.etNivel);

        Bundle b = getIntent().getExtras();
        etNombre.setText(b.getString("Nombre"));
        etApellido.setText(b.getString("Apellido"));
        etGrado.setText(b.getString("Grado"));
        etNivel.setText(b.getString("Nivel"));
    }
}
