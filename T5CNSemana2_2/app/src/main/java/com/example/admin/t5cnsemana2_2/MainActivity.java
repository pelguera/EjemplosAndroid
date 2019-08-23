package com.example.admin.t5cnsemana2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btnAceptar);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Spinner sp=(Spinner)findViewById(R.id.spnDestino);
        RadioGroup rd=(RadioGroup)findViewById(R.id.rdgLinea);
        EditText edt =(EditText)findViewById(R.id.edtNombre);
        CheckBox chkdes=(CheckBox)findViewById(R.id.chkDesc);
        CheckBox chkigv=(CheckBox)findViewById(R.id.chkIgv);
        double precio=0,incremento=0,desc=0,igv=0,total=0;
        switch(sp.getSelectedItemPosition()){
            case 0:precio=120;break;
            case 1:precio=90;break;
            case 2:precio=40;break;
            case 3:precio=60;break;
        }
        switch(rd.getCheckedRadioButtonId()) {
            case R.id.rbtLan:incremento=0;break;
            case R.id.rbtAvianca:incremento=precio*0.08;break;
            case R.id.rbtTaca:incremento=precio * 0.05;break;
        }
        precio = precio +incremento;
        if(chkdes.isChecked()){
            desc = precio * 0.10;
        }
        if(chkigv.isChecked()){
            igv = precio * 0.18;
        }
        total = precio + igv - desc;

        String res="Precio "+precio+
                "\nDescuento "+desc+
                "\nIGV "+igv+
                "\nTotal "+total;

        Toast.makeText(this,res,Toast.LENGTH_LONG).show();
    }
}




