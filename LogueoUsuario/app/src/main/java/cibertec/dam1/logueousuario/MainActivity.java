package cibertec.dam1.logueousuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cibertec.dam1.logueousuario.Dao.UsuarioDAO;
import cibertec.dam1.logueousuario.Modelo.Usuario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvRegistrese;
    private EditText etNombreUsuario;
    private EditText etPasswordUsuario;
    private Button btIngresar;

    private UsuarioDAO usuDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etNombreUsuario = findViewById(R.id.etUsuario);
        this.etPasswordUsuario = findViewById(R.id.etPassword);
        this.btIngresar = findViewById(R.id.btIngresar);
        this.btIngresar.setOnClickListener(this);
        this.tvRegistrese = findViewById(R.id.tvRegistrese);
        this.tvRegistrese.setOnClickListener(this);

        this.usuDao = new UsuarioDAO(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.tvRegistrese){
            Intent intent = new Intent(MainActivity.this, NuevoUsuarioActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btIngresar){
            Usuario usu = new Usuario();
            usu.setEmail(this.etNombreUsuario.getText().toString());
            usu.setPassword(this.etPasswordUsuario.getText().toString());

            Usuario usuvalidado = this.usuDao.validarLogueo(usu);

            if(usuvalidado != null){
                Toast.makeText(this, "se valido el usuario " + usuvalidado.getApellido(), Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Hubo un error en el logueo, verifique sus datos", Toast.LENGTH_LONG).show();
            }
        }

    }
}
