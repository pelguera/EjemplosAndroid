package cibertec.dam1.lp01_t5bm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import cibertec.dam1.lp01_t5bm.R;
import cibertec.dam1.lp01_t5bm.modelo.Empleado;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Empleado> lista;

    public MyAdapter(Context context, int layout, List<Empleado> lista) {
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
        LayoutInflater inflater =LayoutInflater.from(this.context);
        v = inflater.inflate(R.layout.list_item, null);

        Empleado empleado = this.lista.get(position);

        TextView nombre =v.findViewById(R.id.tvNombre);
        TextView apellido = v.findViewById(R.id.tvapellido);
        TextView descripcion = v.findViewById(R.id.tvDescripcion);
        ImageView foto = v.findViewById(R.id.ivFoto);

        nombre.setText(empleado.getNombres());
        apellido.setText(empleado.getApellidos());
        descripcion.setText(empleado.getDocumento());

        int icono = this.context.getResources().getIdentifier(empleado.getNombreImagen(), "mipmap", context.getPackageName());
        foto.setImageResource(icono);

        return v;
    }
}
