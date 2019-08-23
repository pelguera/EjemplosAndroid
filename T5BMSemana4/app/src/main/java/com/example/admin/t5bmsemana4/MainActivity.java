package com.example.admin.t5bmsemana4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.t5bmsemana4.adapter.MiAdaptador;
import com.example.admin.t5bmsemana4.bean.LibroBean;
import com.example.admin.t5bmsemana4.dao.LibroDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lstLibro;

    private void IniciaComponente(){
        lstLibro = (ListView)findViewById(R.id.lstLibros);
    }
    private void PoblarLibros(){
        LibroDAO dao=new LibroDAO();
        ArrayList<LibroBean> libros=dao.ListadoLibros();
        /*
        ArrayAdapter<LibroBean> adapter=
                new ArrayAdapter<LibroBean>(this,
                        android.R.layout.simple_list_item_1,
                        libros);*/
        MiAdaptador adapter=new MiAdaptador(this,libros);
        lstLibro.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IniciaComponente();
        PoblarLibros();
    }

}
