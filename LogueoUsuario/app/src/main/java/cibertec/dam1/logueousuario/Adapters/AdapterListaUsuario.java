package cibertec.dam1.logueousuario.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cibertec.dam1.logueousuario.Modelo.Usuario;
import cibertec.dam1.logueousuario.R;

public class AdapterListaUsuario extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Usuario> usuarios;

    public AdapterListaUsuario(Context context, int layout, List<Usuario> usuarios) {
        this.context = context;
        this.layout = layout;
        this.usuarios = usuarios;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.item_lista_usuario, null);

        Usuario usu = this.usuarios.get(position);

        TextView tvNombreUsuario = view.findViewById(R.id.tvEmailUsuario);
        tvNombreUsuario.setText(usu.getEmail().toString());

        TextView tvNombreYApellido = view.findViewById(R.id.tvNombresApellidosUsuario);
        tvNombreYApellido.setText(usu.getNombre() + " " + usu.getApellido());

        return view;
    }
}
