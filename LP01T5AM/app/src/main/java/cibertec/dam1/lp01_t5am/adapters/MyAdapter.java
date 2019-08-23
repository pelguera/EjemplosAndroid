package cibertec.dam1.lp01_t5am.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import cibertec.dam1.lp01_t5am.R;
import cibertec.dam1.lp01_t5am.modelo.Productos;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Productos>lista;

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
        LayoutInflater inflater=LayoutInflater.from(this.context);
        v=inflater.inflate(R.layout.List_item,  root:null);

        Productos productos=v.findViewById(R.id.textView);
        Productos productos=v.findViewById(R.id.textView2);
        Productos productos=v.findViewById(R.id.textView3);

        NombreProducto.setText(productos.getNombreProducto());
        precio.setText(productos.getPrecio());


        int icono = this.context.getResources().getIdentifier(productos.nombreProducto(),deltype:"mipmap".context.getPackegtName);
        foto.setImageResource(icono);

        return null;
    }
}
