package com.example.l2practicajava;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.SuperHViewHolder> {

    ArrayList<SuperH> listaSuper;
    Context context;

    public Adapter(ArrayList<SuperH> listaSuper, Context context) {
        this.listaSuper = listaSuper;
        this.context = context;
    }

    @NonNull
    @Override
    public SuperHViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SuperHViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_super, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SuperHViewHolder superHViewHolder, int i) {
        final SuperH actual = listaSuper.get(i);
        superHViewHolder.llenarInformacion(actual);
        superHViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSegunda = new Intent(context, DetalleActivity.class);
                intSegunda.putExtra("KEYOBJSUPER", actual);
                context.startActivity(intSegunda);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaSuper.size();
    }

    class SuperHViewHolder extends RecyclerView.ViewHolder {

        public SuperHViewHolder(View itemView) {
            super(itemView);
        }

        public void llenarInformacion(SuperH superheroe) {
            TextView lblNombre = itemView.findViewById(R.id.lblNombre);
            lblNombre.setText(superheroe.getNombre());
        }
    }
}
