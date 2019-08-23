package com.example.admin.t5bmsemana4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.t5bmsemana4.R;
import com.example.admin.t5bmsemana4.bean.LibroBean;

import java.util.ArrayList;

public class MiAdaptador extends BaseAdapter{

    Context contexto;
    ArrayList<LibroBean> libros;
    public MiAdaptador(Context ctx, ArrayList<LibroBean> l){
        contexto=ctx;
        libros=l;
    }
    @Override
    public int getCount() {
        return libros.size();
    }
    @Override
    public Object getItem(int i) {
        return libros.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row;
        LayoutInflater inflater=
                (LayoutInflater) contexto.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.registro,viewGroup,false);

        TextView txtnom,txtautor;
        ImageView img;

        txtnom = (TextView)row.findViewById(R.id.txtNombre);
        txtautor = (TextView)row.findViewById(R.id.txtAutor);
        img =(ImageView)row.findViewById(R.id.imgFoto);

        txtnom.setText(libros.get(i).getNombre());
        txtautor.setText(libros.get(i).getAutor());
        int id;
        id = contexto.getResources().getIdentifier(
                libros.get(i).getPortada(),
                "drawable",
                contexto.getPackageName());
        img.setImageResource(id);
        return row;
    }
}
