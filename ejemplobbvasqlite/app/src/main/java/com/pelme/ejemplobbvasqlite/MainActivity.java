package com.pelme.ejemplobbvasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pelme.ejemplobbvasqlite.dao.UsuarioDAO;
import com.pelme.ejemplobbvasqlite.modelo.Usuario;

import java.util.List;

public class MainActivity extends AppCompatActivity
                            implements View.OnClickListener {

    private EditText etNombre, etApellido, etEdad;
    private Button btnGrabar;

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnGrabar){
            //recojo los datos de los editText
            String nombre = this.etNombre.getText().toString();
            Usuario usuario = new Usuario(nombre,
                    this.etApellido.getText().toString(),
                    this.etEdad.getText().toString());

            //llamo al dao para que inicialice la clase DBHelper
            UsuarioDAO dao = new UsuarioDAO(MainActivity.this);
            //llamo al metodo ingresarUsuario para grabar el registro
            long ingreso = dao.ingresarUsuario(usuario);
            if(ingreso > 0){
                Toast.makeText(MainActivity.this,
                        "Se grabo correctamente",
                        Toast.LENGTH_LONG).show();
            }

            List<Usuario> listado = dao.listarUsuario();
            for(Usuario usu : listado){
                Log.d("MainActivity", usu.getNombre());
            }

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etEdad = findViewById(R.id.etEdad);
        btnGrabar = findViewById(R.id.btnGrabar);
        btnGrabar.setOnClickListener(this);

    }
}
