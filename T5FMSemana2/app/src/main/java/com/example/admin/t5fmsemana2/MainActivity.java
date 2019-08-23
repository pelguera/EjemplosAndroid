package com.example.admin.t5fmsemana2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btnAceptar);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        EditText edtusu,edtpwd;
        edtusu = (EditText) findViewById(R.id.edtUsuario);
        edtpwd = (EditText) findViewById(R.id.edtPassword);
        if(edtusu.getText().toString().equals("ciber") &&
                edtpwd.getText().toString().equals("123")){
            Toast.makeText(this,"BIENVENIDO",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"DENEGADO",Toast.LENGTH_LONG).show();
        }


    }
}
