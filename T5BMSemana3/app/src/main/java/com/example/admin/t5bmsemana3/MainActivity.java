package com.example.admin.t5bmsemana3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.t5bmsemana3.beans.CiudadBean;
import com.example.admin.t5bmsemana3.beans.PaisBean;
import com.example.admin.t5bmsemana3.dao.CiudadDAO;
import com.example.admin.t5bmsemana3.dao.PaisDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener,View.OnClickListener {

    Spinner spnPais,spnCiudad;

    TextView txtnom,txtobs;
    ImageView imgfoto;
    WebView webciu;
    Button btnregresar;

    private void IniciaComponente(){
        spnPais=(Spinner)findViewById(R.id.spnPais);
        spnCiudad=(Spinner)findViewById(R.id.spnCiudad);
        spnPais.setOnItemSelectedListener(this);
        spnCiudad.setOnItemSelectedListener(this);
    }
    private void IniciaComponenteResultado(){
        txtnom =(TextView)findViewById(R.id.txtNombre);
        txtobs =(TextView)findViewById(R.id.txtObservacion);
        imgfoto=(ImageView)findViewById(R.id.imgFoto);
        webciu =(WebView)findViewById(R.id.webCiudad);
        btnregresar =(Button)findViewById(R.id.btnRegresar);
        btnregresar.setOnClickListener(this);
    }

    private void PoblarPais(){
        PaisDAO dao=new PaisDAO();
        ArrayList<PaisBean> paises=dao.ListaPais();
        ArrayAdapter<PaisBean> adapter=
                new ArrayAdapter<PaisBean>(this,
                        android.R.layout.simple_list_item_1,
                        paises);
        spnPais.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IniciaComponente();
        PoblarPais();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView == spnPais){
            PaisBean x=(PaisBean) spnPais.getItemAtPosition(i);
                if(!x.getIdpais().equals("0")) {
                    CiudadDAO dao = new CiudadDAO();
                    ArrayList<CiudadBean> ciudades = dao.ListaCiudad(x.getIdpais());
                    ArrayAdapter<CiudadBean> adapter =
                            new ArrayAdapter<CiudadBean>(this,
                                    android.R.layout.simple_list_item_1,
                                    ciudades);
                    spnCiudad.setAdapter(adapter);
                }
        }
        if(adapterView == spnCiudad){
            CiudadBean x =(CiudadBean)spnCiudad.getItemAtPosition(i);
            //Toast.makeText(this,x.getIdciu(),Toast.LENGTH_LONG).show();
            if(!x.getIdciu().equals("0")) {
                setContentView(R.layout.resultado);
                IniciaComponenteResultado();
                txtnom.setText(x.getNomciu());
                txtobs.setText(x.getObservacion());
                imgfoto.setImageResource(x.getFoto());
                webciu.loadUrl(x.getWeb());
            }
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        setContentView(R.layout.activity_main);
        IniciaComponente();
        PoblarPais();
    }
}
