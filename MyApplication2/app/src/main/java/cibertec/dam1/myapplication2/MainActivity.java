package cibertec.dam1.myapplication2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View etNombres;
    private View etApellidos;
    private View btEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btEnviar = (Button)findViewById(R.id.btEnviar);
        this.btEnviar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText nombre = (EditText)findViewById(R.id.etNombres);
                EditText apellidos = (EditText) findViewById(R.id.etApellidos);
                String msje = "Los datos son: " + nombre.getText() + " " + apellidos.getText();
                Toast.makeText(MainActivity.this, msje, Toast.LENGTH_LONG).show();
            }
        });
    }

}
