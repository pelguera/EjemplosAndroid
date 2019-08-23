package cibertec.dam1.ejemplosqlite.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import cibertec.dam1.ejemplosqlite.Modelo.Usuario;
import cibertec.dam1.ejemplosqlite.R;

public class AdapterUsuarios extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Usuario> lista;


    public AdapterUsuarios(Context context, int layout, List<Usuario> lista) {
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
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.list_item, null);

        Usuario usu = this.lista.get(position);

        TextView tvInfoEmail = v.findViewById(R.id.tvInfoEmail);
        tvInfoEmail.setText(usu.getEmail());

        TextView tvInfoNombres = v.findViewById(R.id.tvInfoNombres);
        tvInfoNombres.setText(usu.getNombre() + " " + usu.getApellido());

        return v;
    }
}
