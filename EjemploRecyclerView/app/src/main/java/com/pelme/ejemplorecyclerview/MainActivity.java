package com.pelme.ejemplorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.pelme.ejemplorecyclerview.adapters.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> names;
    private RecyclerView rvLista;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = this.getAllNames();

        rvLista = findViewById(R.id.rvLista);
        layoutManager = new LinearLayoutManager(this);
        myAdapter = new MyAdapter(R.layout.recycler_view_item, names, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                Toast.makeText(MainActivity.this, "nombre seleccionado: " + name, Toast.LENGTH_LONG).show();
            }
        });
        rvLista.setLayoutManager(layoutManager);
        rvLista.setAdapter(myAdapter);
    }


    private List<String> getAllNames(){
        return new ArrayList<String>(){
            {
                add("Paul");
                add("Claudia");
                add("Caleb");
                add("Fatima");
            }
        };
    }
}
