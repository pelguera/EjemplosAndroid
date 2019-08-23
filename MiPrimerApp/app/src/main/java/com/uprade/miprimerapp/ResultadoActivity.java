package com.uprade.miprimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvDireccion;
    private TextView tvSexo;
    private TextView tvMayor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvNombre = findViewById(R.id.tvNombre);
        tvDireccion = findViewById(R.id.tvDireccion);
        tvSexo = findViewById(R.id.tvSexo);
        tvMayor = findViewById(R.id.tvMayorEdad);

        Bundle bundle = getIntent().getExtras();
        String mayor = "";

        if(bundle.getBoolean("mayorEdad"))
            mayor = "Si es mayor de edad";
        else
            mayor = "No, es menor de edad";

        tvNombre.setText(bundle.getString("nombrePersona"));
        tvDireccion.setText(bundle.getString("direccionPersona"));
        tvSexo.setText(bundle.getString("sexoPersona"));
        tvMayor.setText(mayor);

    }
}
