package cibertec.dam1.el01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etDni , etCliente , etDireccion;
    private RadioGroup rgMenu;
    private RadioButton rgMazda, rgHonda, rgMitsubishi;
    private Button btnComprar;

    private String dni;
    private String cliente;
    private String direccion;
    private String menuCarro;
    private double preciocarro;
    private boolean descuento;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {

        if(v == this.btnComprar){

            this.obtenerDatos();

            Intent intent = new Intent(MainActivity.this, Resultado.class);
            intent.putExtra("dni", this.dni);
            intent.putExtra("cliente", this.cliente);
            intent.putExtra("direccion", this.direccion);
            intent.putExtra("menuCarro", this.menuCarro);
            intent.putExtra("precioCarro", this.preciocarro);
            intent.putExtra("descuento", this.descuento);
            startActivity(intent);
        }


    }
    private void initComponents(){
        this.etDni = (EditText) findViewById(R.id.dni);
        this.etCliente = (EditText) findViewById(R.id.cliente);
        this.etDireccion = (EditText) findViewById(R.id.direccion);
        this.rgMenu = (RadioGroup) findViewById(R.id.rgMenu);
        this.rgMazda= (RadioButton) findViewById(R.id.rgMazda);
        this.rgHonda = (RadioButton) findViewById(R.id.rgHonda);
        this.rgMitsubishi = (RadioButton) findViewById(R.id.rgMitsubishi);
        this.btnComprar = (Button) findViewById(R.id.btnComprar);
        this.btnComprar.setOnClickListener(this);
    }
    private void obtenerDatos(){

        this.cliente = this.etCliente.getText().toString();

        switch (this.rgMenu.getCheckedRadioButtonId()){

            case R.id.rgMazda:
                this.menuCarro = "2016";
                this.preciocarro = 17500;
                break;
            case R.id.rgHonda:
                this.menuCarro = "2017";
                this.preciocarro = 22000;
                break;
            case R.id.rgMitsubishi:
                this.menuCarro = "2018";
                this.preciocarro = 19000;
                break;
        }
    }
    public EditText getEtDni() {
        return etDni;
    }

    public void setEtDni(EditText etDni) {
        this.etDni = etDni;
    }

    public EditText getEtCliente() {
        return etCliente;
    }

    public void setEtCliente(EditText etCliente) {
        this.etCliente = etCliente;
    }

    public EditText getEtDireccion() {
        return etDireccion;
    }

    public void setEtDireccion(EditText etDireccion) {
        this.etDireccion = etDireccion;
    }

    public RadioGroup getRgMenu() {
        return rgMenu;
    }

    public void setRgMenu(RadioGroup rgMenu) {
        this.rgMenu = rgMenu;
    }

    public RadioButton getRgMazda() {
        return rgMazda;
    }

    public void setRgMazda(RadioButton rgMazda) {
        this.rgMazda = rgMazda;
    }

    public RadioButton getRgHonda() {
        return rgHonda;
    }

    public void setRgHonda(RadioButton rgHonda) {
        this.rgHonda = rgHonda;
    }

    public RadioButton getRgMitsubishi() {
        return rgMitsubishi;
    }

    public void setRgMitsubishi(RadioButton rgMitsubishi) {
        this.rgMitsubishi = rgMitsubishi;
    }

    public Button getBtnComprar() {
        return btnComprar;
    }

    public void setBtnComprar(Button btnComprar) {
        this.btnComprar = btnComprar;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMenuCarro() {
        return menuCarro;
    }

    public void setMenuCarro(String menuCarro) {
        this.menuCarro = menuCarro;
    }

    public double getPreciocarro() {
        return preciocarro;
    }

    public void setPreciocarro(double preciocarro) {
        this.preciocarro = preciocarro;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }
}
