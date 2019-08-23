package cibertec.dam1.t5bmclase13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cibertec.dam1.t5bmclase13.interfaces.SuperHeroeInterface;
import cibertec.dam1.t5bmclase13.modelo.Heroe;
import cibertec.dam1.t5bmclase13.utils.Constantes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etCodigo;
    private Button btnBuscar;
    private TextView tvNombreSuperheroe, tvInteligenciaSuperHeroe,
            tvPoderSuperHeroe, tvVelocidadSuperHeroe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etCodigo = findViewById(R.id.etCodigoHeroe);
        this.btnBuscar = findViewById(R.id.btnBuscar);
        this.tvNombreSuperheroe = findViewById(R.id.tvNombreSuperheroe);
        this.tvInteligenciaSuperHeroe = findViewById(R.id.tvInteligenciaSuperHeroe);
        this.tvPoderSuperHeroe = findViewById(R.id.tvPoderSuperHeroe);
        this.tvVelocidadSuperHeroe = findViewById(R.id.tvVelocidadSuperHeroe);
        this.btnBuscar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == v.getId()){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constantes.BASE_URL + Constantes.SUPERHERO_TOKEN)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            SuperHeroeInterface service = retrofit.create(SuperHeroeInterface.class);
            Call<Heroe> heroe = service.getHeroe(this.etCodigo.getText().toString());

            heroe.enqueue(new Callback<Heroe>() {
                @Override
                public void onResponse(Call<Heroe> call, Response<Heroe> response) {
                    Heroe h = response.body();

                    tvNombreSuperheroe.setText(h.getName());
                    tvInteligenciaSuperHeroe.setText(h.getPoderes().getInteligencia());
                    tvPoderSuperHeroe.setText(h.getPoderes().getPoder());
                    tvVelocidadSuperHeroe.setText(h.getPoderes().getSpeed());

                    Toast.makeText(MainActivity.this, "El servicio se ejecuto correctamente", Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(Call<Heroe> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Hubo problemas para ejecutar el servicio", Toast.LENGTH_LONG).show();
                }
            });

        }

    }
}
