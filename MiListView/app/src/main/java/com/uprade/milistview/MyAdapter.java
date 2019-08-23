package com.uprade.milistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private int layout;
    private List<String> nombres;
    private Context context;

    public MyAdapter(int layout, List<String> nombres, Context context) {
        this.layout = layout;
        this.nombres = nombres;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.nombres.size();
    }

    @Override
    public Object getItem(int i) {
        return this.nombres.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;

        LayoutInflater inflater = LayoutInflater.from(this.context);
        v = inflater.inflate(this.layout, null);

        ImageView ivIcono = v.findViewById(R.id.ivIcon);
        TextView tvNombre = v.findViewById(R.id.tvNombre);

        tvNombre.setText(this.nombres.get(i));

        return v;
    }
}
