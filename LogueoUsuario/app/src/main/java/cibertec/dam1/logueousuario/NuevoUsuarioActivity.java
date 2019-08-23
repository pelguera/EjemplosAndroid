package cibertec.dam1.logueousuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cibertec.dam1.logueousuario.Dao.UsuarioDAO;
import cibertec.dam1.logueousuario.Modelo.Usuario;

public class NuevoUsuarioActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmailUsuario;
    private EditText etNombreUsuario;
    private EditText etApellidoUsuario;
    private EditText etPasswordUsuario01;
    private EditText etPasswordUsuario02;
    private Button btRegistrar;
    private Button btMostrar;

    private UsuarioDAO usuDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);

        this.etEmailUsuario = findViewById(R.id.etEmail);
        this.etNombreUsuario = findViewById(R.id.etNombreUsuario);
        this.etApellidoUsuario = findViewById(R.id.etApellidosUsuario);
        this.etPasswordUsuario01 = findViewById(R.id.etPassword01);
        this.etPasswordUsuario02 = findViewById(R.id.etPassword02);
        this.btRegistrar = findViewById(R.id.btRegistrar);
        this.btRegistrar.setOnClickListener(this);
        this.btMostrar = findViewById(R.id.btnMostrar);
        this.btMostrar.setOnClickListener(this);
        this.usuDao = new UsuarioDAO(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btRegistrar){
            Usuario usuario = new Usuario();
            usuario.setNombre(this.etNombreUsuario.getText().toString());
            usuario.setApellido(this.etApellidoUsuario.getText().toString());
            usuario.setEmail(this.etEmailUsuario.getText().toString());
            usuario.setPassword(this.etPasswordUsuario01.getText().toString());

            long rowId = this.usuDao.registrarUsuario(usuario);

            if(rowId > 0){
                Toast.makeText(NuevoUsuarioActivity.this, "Se registro el usuario correctamente", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(NuevoUsuarioActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }else if(v.getId() == R.id.btnMostrar){

            Intent intentListarUsuario = new Intent(this, ListarUsuarioActivity.class);
            startActivity(intentListarUsuario);
        }
    }
}
