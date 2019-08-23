package cibertec.dam1.consumoservicioslistview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cibertec.dam1.consumoservicioslistview.R;
import cibertec.dam1.consumoservicioslistview.modelo.Heroe;

public class SuperHeroAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Heroe> listaHeroes;

    public SuperHeroAdapter(Context context, int layout, List<Heroe> listaHeroes) {
        this.context = context;
        this.layout = layout;
        this.listaHeroes = listaHeroes;
    }

    @Override
    public int getCount() {
        return this.listaHeroes.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listaHeroes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = LayoutInflater.from(context);
        v = inflater.inflate(R.layout.item_superheroe, null);

        TextView nombreSuperHeroe = v.findViewById(R.id.tvNombreSuperHeroe);
        TextView nombreCompletoSuperHeroe = v.findViewById(R.id.tvNombreCompleto);

        nombreSuperHeroe.setText(this.listaHeroes.get(position).getName());
        nombreCompletoSuperHeroe.setText(this.listaHeroes.get(position).getBiografia().getFullName());


        return v;
    }
}
