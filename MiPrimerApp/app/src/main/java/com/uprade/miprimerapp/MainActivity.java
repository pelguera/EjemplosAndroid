package com.uprade.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNombre;
    private EditText etDireccion;
    private Spinner spSexo;
    private CheckBox cbMayor;
    private Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombrePersona);
        etDireccion = findViewById(R.id.etDireccion);
        spSexo = findViewById(R.id.spSexo);
        cbMayor = findViewById(R.id.cbMayor);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String nombre = etNombre.getText().toString();
        String direccion = etDireccion.getText().toString();

        String sexo = "";
        switch (spSexo.getSelectedItemPosition()){
            case 1:
                sexo = "Masculino";
                break;
            case 2:
                sexo = "Femenino";
                break;
        }

        boolean mayor = cbMayor.isChecked();

        Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);

        intent.putExtra("nombrePersona", nombre);
        intent.putExtra("direccionPersona", direccion);
        intent.putExtra("sexoPersona", sexo);
        intent.putExtra("mayorEdad", mayor);
        startActivity(intent);

    }
}
