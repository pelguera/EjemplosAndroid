package cibertec.dam1.getdog.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import cibertec.dam1.getdog.Modelo.Usuario;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Usuario> listaUsuario;

    public MyAdapter(Context context, int layout, List<Usuario> listaUsuario) {
        this.context = context;
        this.layout = layout;
        this.listaUsuario = listaUsuario;
    }

    @Override
    public int getCount() {
        return listaUsuario.size();
    }

    @Override
    public Object getItem(int position) {
        return listaUsuario.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
