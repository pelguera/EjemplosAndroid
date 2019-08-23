package cibertec.dam1.getdog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cibertec.dam1.getdog.DAO.UsuarioDAO;
import cibertec.dam1.getdog.Modelo.Usuario;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsuario, etPassword;
    private Button btIngresar;
    private TextView tvRegistrarse;

    private Usuario usuario;
    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etUsuario=findViewById(R.id.etUsuario);
        this.etPassword=findViewById(R.id.etPassword);
        this.btIngresar=findViewById(R.id.btIngresar);
        this.tvRegistrarse=findViewById(R.id.tvRegistrese);

        this.btIngresar.setOnClickListener(this);
        this.tvRegistrarse.setOnClickListener(this);
        this.usuarioDAO=new UsuarioDAO(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btIngresar){
            this.usuario=new Usuario();
            usuario.setEmail(this.etUsuario.getText().toString());
            usuario.setPassword(this.etPassword.getText().toString());

            Usuario validarLogueo=usuarioDAO.validarUsuario(this.usuario);

            if(etUsuario.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this, "Ingrese el usuario!", Toast.LENGTH_LONG).show();
            }else if(etPassword.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this, "Ingrese el password!", Toast.LENGTH_LONG).show();
            }else if(validarLogueo!=null){
                // Toast.makeText(MainActivity.this,"Usuario logueado correctamente",Toast.LENGTH_LONG).show();
                 Intent i=new Intent(MainActivity.this,ActivityItems.class);
                 startActivity(i);
            }else {
            Toast.makeText(MainActivity.this,"Usuario o contraseña incorrecto!",Toast.LENGTH_LONG).show();
            }
        }else if(v.getId() == R.id.tvRegistrese){
            Intent i=new Intent(MainActivity.this,NuevoUsuarioActivity.class);
            startActivity(i);
        }

    }
}
