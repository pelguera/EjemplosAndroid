package cibertec.dam1.ejemplosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cibertec.dam1.ejemplosqlite.DAO.UsuarioDAO;
import cibertec.dam1.ejemplosqlite.Modelo.Usuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvRegistrese;
    private EditText etNombreUsuario;
    private EditText etPasswordUsuario;
    private Button btIngresar;

    private UsuarioDAO usuarioDAO;

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btIngresar){

            Usuario usu = new Usuario();
            usu.setEmail(this.etNombreUsuario.getText().toString());
            usu.setPassword(this.etPasswordUsuario.getText().toString());

            Usuario logueo = usuarioDAO.validarLogueo(usu);

            if(logueo != null){
                Toast.makeText(MainActivity.this, "Usuario logueado correctamente", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MainActivity.this, "Hubo problemas al validar el usuario", Toast.LENGTH_LONG).show();
            }


        }else if(v.getId() == R.id.tvRegistrese){
            Intent i = new Intent(MainActivity.this, NuevoUsuarioActivity.class);
            startActivity(i);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etNombreUsuario = findViewById(R.id.etUsuario);
        this.etPasswordUsuario = findViewById(R.id.etPassword);
        this.btIngresar = findViewById(R.id.btIngresar);
        this.tvRegistrese = findViewById(R.id.tvRegistrese);

        this.btIngresar.setOnClickListener(this);
        this.tvRegistrese.setOnClickListener(this);

        this.usuarioDAO = new UsuarioDAO(this);

    }
}
