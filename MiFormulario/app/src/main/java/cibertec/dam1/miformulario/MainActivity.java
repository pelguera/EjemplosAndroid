package cibertec.dam1.miformulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etCliente;
    private Spinner spDistrito;
    private RadioGroup rgMenu;
    private RadioButton rbMenuEconomico, rbMenuEjecutivo, rbMenuCarta;
    private CheckBox chkDescuento;
    private Button btnEnviar;

    private String nombreCliente;
    private String distritoCliente;
    private String menuCliente;
    private double precioMenu;
    private boolean aplicaDsctoCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initComponents();
    }

    @Override
    public void onClick(View v) {

        if(v == this.btnEnviar){
            // desarrollar lo que quiero q se haga al clickear el boton enviar
            this.obtenerDatos();
            //crear el intent
            Intent intent = new Intent(MainActivity.this, Resultado.class);
            intent.putExtra("nombreCliente", this.nombreCliente);
            intent.putExtra("distritoCliente", this.distritoCliente);
            intent.putExtra("menuCliente", this.menuCliente);
            intent.putExtra("precioMenu", this.precioMenu);
            intent.putExtra("aplicaDescuento", this.aplicaDsctoCliente);
            startActivity(intent);
        }

    }

    private void initComponents(){
        this.etCliente = (EditText) findViewById(R.id.etCliente);
        this.spDistrito = (Spinner) findViewById(R.id.spDistrito);
        this.rgMenu = (RadioGroup) findViewById(R.id.rgMenu);
        this.rbMenuEconomico = (RadioButton) findViewById(R.id.rbMenuEconomico);
        this.rbMenuEjecutivo = (RadioButton) findViewById(R.id.rbMenuEjecutivo);
        this.rbMenuCarta = (RadioButton) findViewById(R.id.rbMenuCarta);
        this.chkDescuento = (CheckBox) findViewById(R.id.chkDescuento);
        this.btnEnviar = (Button) findViewById(R.id.btnEnviar);
        this.btnEnviar.setOnClickListener(this);
    }

    private void obtenerDatos(){

        this.nombreCliente = this.etCliente.getText().toString();
        switch (this.spDistrito.getSelectedItemPosition()){
            case 0:
                this.distritoCliente = "Miraflores";
                break;
            case 1:
                this.distritoCliente = "Breña";
                break;
            case 2:
                this.distritoCliente = "Callao";
                break;
            case 3:
                this.distritoCliente = "Independencia";
                break;
        }
        System.out.println("valor combo getSelectedItemId::: " + this.spDistrito.getSelectedItemId());
        System.out.println("valor combo getSelectedItem::: " + this.spDistrito.getSelectedItem());
        switch (this.rgMenu.getCheckedRadioButtonId()){

            case R.id.rbMenuEconomico:
                this.menuCliente = "Economico";
                this.precioMenu = 5;
                break;
            case R.id.rbMenuEjecutivo:
                this.menuCliente = "Ejecutivo";
                this.precioMenu = 12;
                break;
            case R.id.rbMenuCarta:
                this.menuCliente = "Carta";
                this.precioMenu = 20;
                break;
        }

        this.aplicaDsctoCliente = this.chkDescuento.isChecked();
    }

}
