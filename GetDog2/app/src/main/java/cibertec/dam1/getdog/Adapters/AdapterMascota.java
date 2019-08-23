package cibertec.dam1.getdog.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cibertec.dam1.getdog.Modelo.Mascotas;
import cibertec.dam1.getdog.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterMascota extends BaseAdapter {

    private Context context;
    private  int layout;
    private List<Mascotas>lista;

    public AdapterMascota(Context context, int layout, List<Mascotas> lista) {
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
        View v=convertView;
        LayoutInflater inflater=LayoutInflater.from(this.context);
        v=inflater.inflate(R.layout.list_item,null);

        Mascotas mascotas=this.lista.get(position);

        TextView nombre=v.findViewById(R.id.tvNombre);
        TextView estado=v.findViewById(R.id.tvEstado);
        TextView direccion=v.findViewById(R.id.tvDescripcion);
        TextView fecha=v.findViewById(R.id.tvFecha);
        CircleImageView foto=v.findViewById(R.id.civFotoMascota);

        nombre.setText(mascotas.getNombre());
        estado.setText(mascotas.getEstado());
        fecha.setText(mascotas.getFecha());
        direccion.setText(mascotas.getDescripcion());

        int icono=this.context.getResources().getIdentifier(mascotas.getNombreFoto(),"mipmap",context.getPackageName());
        foto.setImageResource(icono);

        return v;
    }
}
