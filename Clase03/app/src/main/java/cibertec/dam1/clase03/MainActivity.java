package cibertec.dam1.clase03;

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

    private EditText etNombres, etDireccion;
    private Spinner spDistrito;
    private RadioGroup rgAuto;
    private RadioButton rbMazda;
    private RadioButton rbHonda;
    private RadioButton rbSubaru;
    private CheckBox chkDscto, chkIgv;
    private Button btnEnviar;

    private String nombreCliente;
    private String direccionCliente;
    private String distritoCliente;
    private String autoCliente;
    private boolean aplicaDsctoCliente;
    private boolean incluirIgvCliente;
    private double precioAuto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initComponentes();
    }

    private void initComponentes(){
        this.etNombres = (EditText) findViewById(R.id.etNombres);
        this.etDireccion = (EditText) findViewById(R.id.etDireccion);
        this.spDistrito = (Spinner) findViewById(R.id.spDistrito);
        this.rgAuto = (RadioGroup) findViewById(R.id.rgAuto);
        this.rbHonda = (RadioButton) findViewById(R.id.rbHonda);
        this.rbMazda = (RadioButton) findViewById(R.id.rbMazda);
        this.rbSubaru = (RadioButton) findViewById(R.id.rbSubaru);
        this.chkDscto = (CheckBox) findViewById(R.id.chkDscto);
        this.chkIgv = (CheckBox) findViewById(R.id.chkIgv);
        this.btnEnviar = (Button) findViewById(R.id.btEnviar);
        this.btnEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == this.btnEnviar){

            Intent intent = new Intent(MainActivity.this, ProformaActivity.class);
            this.obtenerDatos();
            intent.putExtra("nombreCliente", this.getNombreCliente());
            intent.putExtra("direccionCliente", this.getDireccionCliente());
            intent.putExtra("distritoCliente", this.getDistritoCliente());
            intent.putExtra("autoCliente", this.getAutoCliente());
            intent.putExtra("precioAuto", this.getPrecioAuto());
            intent.putExtra("aplicaDscto", this.isAplicaDsctoCliente());
            intent.putExtra("incluirIgv", this.isIncluirIgvCliente());
            startActivity(intent);
        }

    }


    private void obtenerDatos(){
        this.setNombreCliente(this.etNombres.getText().toString());
        this.setDireccionCliente(this.etDireccion.getText().toString());

        switch (this.spDistrito.getSelectedItemPosition()){
            case 0:
                this.setDistritoCliente("MIRAFLORES");
                break;
            case 1:
                this.setDistritoCliente("BREÑA");
                break;
            case 2:
                this.setDistritoCliente("CALLAO");
                break;
            case 3:
                this.setDistritoCliente("INDEPENDENCIA");
                break;
        }

        switch (this.rgAuto.getCheckedRadioButtonId()){
            case R.id.rbHonda:
                this.setAutoCliente("Honda - CRV");
                this.setPrecioAuto(24000);
                break;
            case R.id.rbMazda:
                this.setAutoCliente("Mazda - Mazda3");
                this.setPrecioAuto(17500);
                break;
            case R.id.rbSubaru:
                this.setAutoCliente("Subaru - Impreza");
                this.setPrecioAuto(21000);
                break;
        }

        if(this.chkDscto.isChecked())
            this.setAplicaDsctoCliente(true);

        if(this.chkIgv.isChecked())
            this.setIncluirIgvCliente(true);
    }




    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getDistritoCliente() {
        return distritoCliente;
    }

    public void setDistritoCliente(String distritoCliente) {
        this.distritoCliente = distritoCliente;
    }

    public String getAutoCliente() {
        return autoCliente;
    }

    public void setAutoCliente(String autoCliente) {
        this.autoCliente = autoCliente;
    }

    public boolean isAplicaDsctoCliente() {
        return aplicaDsctoCliente;
    }

    public void setAplicaDsctoCliente(boolean aplicaDsctoCliente) {
        this.aplicaDsctoCliente = aplicaDsctoCliente;
    }

    public boolean isIncluirIgvCliente() {
        return incluirIgvCliente;
    }

    public void setIncluirIgvCliente(boolean incluirIgvCliente) {
        this.incluirIgvCliente = incluirIgvCliente;
    }

    public double getPrecioAuto() {
        return precioAuto;
    }

    public void setPrecioAuto(double precioAuto) {
        this.precioAuto = precioAuto;
    }

}
