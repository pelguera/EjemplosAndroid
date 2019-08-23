package com.cibertec.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cibertec.myapplication.R;

import java.util.List;

public class AdapterContacto extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Contacto> lista;

    public AdapterContacto(Context context, int layout, List<Contacto> lista) {
        this.context = context;
        this.layout = layout;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();

            holder.ivFoto = convertView.findViewById(R.id.ivFotoContacto);
            holder.tvDetalleNombre = convertView.findViewById(R.id.tvDetalleNombre);
            holder.tvDetalleTipo = convertView.findViewById(R.id.tvDetalleTipo );

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        //Obtengo el objeto que usare para sacar la informacion
        Contacto contacto = this.lista.get(position);
        //seteo los datos en los componentes
        holder.tvDetalleNombre.setText(contacto.getNombreProducto());
        holder.tvDetalleTipo .setText(contacto.getTipo());

        int icono = this.context.getResources()
                .getIdentifier(contacto.getTipo(), "mipmap",
                        this.context.getPackageName());
        holder.ivFoto.setImageResource(icono);

        return convertView;

    }


    static class ViewHolder{

        private TextView tvDetalleNombre;
        private TextView tvDetalleTipo;
        private ImageView ivFoto;

    }


}











