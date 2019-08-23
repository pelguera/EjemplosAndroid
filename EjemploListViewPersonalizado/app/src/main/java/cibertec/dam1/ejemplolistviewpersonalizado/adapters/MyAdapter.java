package cibertec.dam1.ejemplolistviewpersonalizado.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cibertec.dam1.ejemplolistviewpersonalizado.R;
import cibertec.dam1.ejemplolistviewpersonalizado.modelo.Jugadores;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Jugadores> lista;

    public MyAdapter(Context context, int layout, List<Jugadores> lista) {
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

        //Patron View Holder
        ViewHolder holder;
        if(convertView == null){
            // inflamos la vista que nos ha llegado personalizado con nuestro layout
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(this.layout, null);

            holder = new ViewHolder();
            //referenciamos todos los elementos a modificar y lo rellenamos
            holder.tvNombreVH = convertView.findViewById(R.id.tvNombre);
            holder.tvDescripcionVH = convertView.findViewById(R.id.tvDescripcion);
            holder.ivFotoVH = convertView.findViewById(R.id.ivFoto);

            //le pasamos toda la referencia del objeto holder a la vista para obtenerla despues
            convertView.setTag(holder);
        }else{
            //aca obtenemos la referencia del objeto holder, si es que no es null
            holder = (ViewHolder) convertView.getTag();
        }

        Jugadores jugador = this.lista.get(position);
        holder.tvNombreVH.setText(jugador.getNombre());
        holder.tvDescripcionVH.setText(jugador.getDescripcion());

        int icono = this.context.getResources().getIdentifier(jugador.getNombreFoto(),
                "mipmap",
                context.getPackageName());
        holder.ivFotoVH.setImageResource(icono);

        return convertView;

        /*
        View v = convertView;
        LayoutInflater inflater = LayoutInflater.from(this.context);
        v = inflater.inflate(R.layout.list_item, null);

        Jugadores jugador = this.lista.get(position);

        TextView nombre = v.findViewById(R.id.tvNombre);
        TextView descripcion = v.findViewById(R.id.tvDescripcion);
        ImageView foto = v.findViewById(R.id.ivFoto);

        nombre.setText(jugador.getNombre());
        descripcion.setText(jugador.getDescripcion());

        int icono = this.context.getResources().getIdentifier(jugador.getNombreFoto(),
                                                            "mipmap",
                                                                context.getPackageName());
        foto.setImageResource(icono);

        return v;
        */
    }

    static class ViewHolder{
        private TextView tvNombreVH;
        private TextView tvDescripcionVH;
        private ImageView ivFotoVH;
    }

}
