package cibertec.dam1.el02t5bm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cibertec.dam1.el02t5bm.R;
import cibertec.dam1.el02t5bm.modelo.Alumno;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Alumno> lista;

    public MyAdapter(Context context, int layout, List<Alumno> lista) {
        this.context = context;
        this.layout = layout;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return this.lista.size();
    }

    @Override
    public Object getItem(int position) {
        return this.lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = LayoutInflater.from(this.context);
        v = inflater.inflate(R.layout.list_item, null);

        Alumno alumno = this.lista.get(position);

        TextView nombre = v.findViewById(R.id.tvNombre);
        TextView apellido = v.findViewById(R.id.tvApellido);



        nombre.setText(alumno.getNombre());
        apellido.setText(alumno.getApellido());



        return v;
    }
}
