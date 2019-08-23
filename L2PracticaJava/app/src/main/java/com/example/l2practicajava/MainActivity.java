package com.example.l2practicajava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<SuperH> listaSuperH = new ArrayList<>();
    private RecyclerView rvSUperH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBuscar = findViewById(R.id.btnBuscar);
        final EditText txtHeroe = findViewById(R.id.txtSuperHeroe);
        rvSUperH = findViewById(R.id.rvSuperH);

        rvSUperH.setLayoutManager(new LinearLayoutManager(this));

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(txtHeroe.getText().toString())) {
                    buscar(txtHeroe.getText().toString().trim());
                }
            }
        });
    }

    private void buscar(String heroe) {
        System.out.println("SUPER "+ heroe);
        listaSuperH.clear();
        final String url = "https://www.superheroapi.com/api.php/1043102082542045/search/" + heroe;
        System.out.println("URL "+ url);
        AndroidNetworking.get(url)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println("response "+ response);
                        try {

                            final JSONArray resultados = response.getJSONArray("results");
                            for (int i = 0; i < resultados.length(); i++) {
                                final JSONObject jsonObj = resultados.getJSONObject(i);
                                final String id = jsonObj.getString("id");
                                final String nombre = jsonObj.getString("name");
                                final JSONObject imagen = jsonObj.getJSONObject("image");
                                final String urlImagen = imagen.getString("url");

                                listaSuperH.add(new SuperH(id, nombre, urlImagen));
                            }

                            final Adapter adaptador = new Adapter(listaSuperH, getApplicationContext());

                            rvSUperH.setAdapter(adaptador);
                        } catch (JSONException jex) {
                            System.out.println("jex "+ jex);
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        System.out.println("anError "+ anError);
                    }
                });
    }
}
