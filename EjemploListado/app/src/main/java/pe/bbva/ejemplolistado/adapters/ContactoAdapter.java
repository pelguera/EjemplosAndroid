package pe.bbva.ejemplolistado.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.bbva.ejemplolistado.R;
import pe.bbva.ejemplolistado.modelo.Contacto;

public class ContactoAdapter extends BaseAdapter {

    private int layout;
    private Context context;
    private List<Contacto> listado;

    public ContactoAdapter(int layout, Context context, List<Contacto> listado) {
        this.layout = layout;
        this.context = context;
        this.listado = listado;
    }

    @Override
    public int getCount() {
        return this.listado.size();
    }

    @Override
    public Object getItem(int i) {
        return this.listado.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(layout, null);

        ImageView ivFoto = v.findViewById(R.id.ivFoto);
        TextView tvNombre = v.findViewById(R.id.tvNombre);

        tvNombre.setText(this.listado.get(i).getNombre());
        ivFoto.setImageResource(this.listado.get(i).getIdFoto());


        return v;
    }
}
