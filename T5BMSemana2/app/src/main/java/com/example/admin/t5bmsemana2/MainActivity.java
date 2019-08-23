package com.example.admin.t5bmsemana2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnaceptar,btnregesar;
    EditText edtPasajero;
    Spinner spnDestino;
    RadioButton rbtLan,rbtAvianca,rbtChosicano;
    RadioGroup rdgLinea;
    CheckBox chkDesc,chkIgv;
    TextView txtdestino,txtlinea,txtpasajero,txtigv,txtdesc,txtpre,txtprefinal;
    public void initComponentPantalla2(){
        txtdestino=(TextView)findViewById(R.id.txtDestino);
        txtlinea=(TextView)findViewById(R.id.txtLinea);
        txtpasajero=(TextView)findViewById(R.id.txtPasajero);
        txtdesc=(TextView)findViewById(R.id.txtDescuento);
        txtigv=(TextView)findViewById(R.id.txtIGV);
        txtpre=(TextView)findViewById(R.id.txtPrecio);
        txtprefinal=(TextView)findViewById(R.id.txtPrecioFinal);
        btnregesar=(Button)findViewById(R.id.btnRegresar);
        btnregesar.setOnClickListener(this);
    }
    public void initComponentPantalla1(){
        spnDestino = (Spinner)findViewById(R.id.spnDestino);
        rbtLan =(RadioButton)findViewById(R.id.rbtLan);
        rbtAvianca =(RadioButton)findViewById(R.id.rbtAvianca);
        rbtChosicano =(RadioButton)findViewById(R.id.rbtChosicano);
        rdgLinea=(RadioGroup)findViewById(R.id.rdgLinea);
        edtPasajero =(EditText)findViewById(R.id.edtPasajero);
        chkDesc=(CheckBox)findViewById(R.id.chkDescuento);
        chkIgv=(CheckBox)findViewById(R.id.chkIgv);
        btnaceptar =(Button)findViewById(R.id.btnReservar);
        btnaceptar.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponentPantalla1();
    }
    @Override
    public void onClick(View view) {
        if(view == btnaceptar){
            double precio=0,recargo=0,desc=0,igv=0,total=0;
            String linea="",ciudad="",nombre="";


            switch(spnDestino.getSelectedItemPosition()){
                case 0:precio=120;ciudad="TUMBES";break;
                case 1:precio=80;ciudad="CUZCO";break;
                case 2:precio=60;ciudad="ANCASH";break;
                case 3:precio=90;ciudad="AREQUIPA";break;
            }
            switch(rdgLinea.getCheckedRadioButtonId()){
                case R.id.rbtLan:recargo=precio*0.10;linea="LAN";break;
                case R.id.rbtAvianca:recargo=precio*0.12;linea="AVIANCA";break;
                case R.id.rbtChosicano:recargo=0;linea="CHOSICANO FLY";break;
            }
            if(chkDesc.isChecked()){
                desc = precio*0.10;
            }
            if(chkIgv.isChecked()){
                igv = precio*0.18;
            }
            total = precio+recargo+igv-desc;
            nombre = edtPasajero.getText().toString();
            setContentView(R.layout.resultado);
            initComponentPantalla2();
            txtdestino.setText(ciudad);
            txtlinea.setText(linea);
            txtpasajero.setText(nombre);
            txtdesc.setText(String.valueOf(desc));
            txtpre.setText(String.valueOf(precio));
            txtprefinal.setText(String.valueOf(total));
            txtigv.setText(String.valueOf(igv));
        }
        if(view == btnregesar){
            setContentView(R.layout.activity_main);
            initComponentPantalla1();
        }
    }
}
