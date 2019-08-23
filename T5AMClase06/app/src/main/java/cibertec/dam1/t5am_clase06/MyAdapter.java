package cibertec.dam1.t5am_clase06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Contacto> lista;

    public MyAdapter(Context context, int layout, List<Contacto> lista){
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
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // View Holder pattern
        ViewHolder holder;
        if(convertView == null){

            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.nombreTextView = (TextView) convertView.findViewById(R.id.tvNombres);
            holder.descripcionTextView = (TextView) convertView.findViewById(R.id.tvDescripcion);
            holder.fotoImageView = (ImageView) convertView.findViewById(R.id.ivFoto);

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Contacto contacto = lista.get(position);

        holder.descripcionTextView.setText(contacto.getEstado());
        holder.nombreTextView.setText(contacto.getNombre());
        int icono = context.getResources().getIdentifier(contacto.getNombreFoto(), "mipmap", context.getPackageName());
        holder.fotoImageView.setImageResource(icono);

        return convertView;
    }

/*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.list_item, null);

        Contacto contacto = lista.get(position);
        TextView descripcion = v.findViewById(R.id.tvDescripcion);
        descripcion.setText(contacto.getEstado());

        TextView nombre = v.findViewById(R.id.tvNombres);
        nombre.setText(contacto.getNombre());

        ImageView imagen = v.findViewById(R.id.ivFoto);
        int icono = context.getResources().getIdentifier(contacto.getNombreFoto(), "mipmap", context.getPackageName());
        imagen.setImageResource(icono);

        return v;
    }
*/



    static class ViewHolder{

        private TextView nombreTextView, descripcionTextView;
        private ImageView fotoImageView;
    }

}
