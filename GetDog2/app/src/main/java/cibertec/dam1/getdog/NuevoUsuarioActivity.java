package cibertec.dam1.getdog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cibertec.dam1.getdog.DAO.UsuarioDAO;
import cibertec.dam1.getdog.Modelo.Usuario;

public class NuevoUsuarioActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNombre,etApellido,etCorreo,etContraseña;
    private Button btCrearCuenta;

    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);

        this.etNombre=findViewById(R.id.etNombre);
        this.etApellido=findViewById(R.id.etApellido);
        this.etCorreo=findViewById(R.id.etCorreo);
        this.etContraseña=findViewById(R.id.etContraseña);
        this.btCrearCuenta=findViewById(R.id.btCrearCuenta);

        this.btCrearCuenta.setOnClickListener(this);
        this.usuarioDAO=new UsuarioDAO(this);

    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btCrearCuenta){
            Usuario u=new Usuario();
            u.setNombre(this.etNombre.getText().toString());
            u.setApellido(this.etApellido.getText().toString());
            u.setEmail(this.etCorreo.getText().toString());
            u.setPassword(this.etContraseña.getText().toString());

            long rowId= this.usuarioDAO.registrarUsuario(u);
            Toast.makeText(NuevoUsuarioActivity.this,"c: "+rowId,Toast.LENGTH_LONG).show();

            if(etNombre.getText().toString().isEmpty()){
                Toast.makeText(NuevoUsuarioActivity.this,"Ingrese nombre!",Toast.LENGTH_LONG).show();
            }else if(etCorreo.getText().toString().isEmpty()){
                Toast.makeText(NuevoUsuarioActivity.this,"Ingrese correo!",Toast.LENGTH_LONG).show();
            }else if(etContraseña.getText().toString().isEmpty()){
                Toast.makeText(NuevoUsuarioActivity.this,"Ingrese contraseña!",Toast.LENGTH_LONG).show();
            }else if(rowId>0){
                Toast.makeText(NuevoUsuarioActivity.this,"Usuario registrado",Toast.LENGTH_LONG).show();
                Intent i=new Intent(NuevoUsuarioActivity.this,MainActivity.class);
                startActivity(i);
            }else {
                Toast.makeText(NuevoUsuarioActivity.this,"Hubo problemas al registrar usuario",Toast.LENGTH_LONG).show();
            }
        }
    }
}
