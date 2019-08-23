package cibertec.dam1.examenfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cibertec.dam1.examenfinal.interfaces.SuperHeroInterface;
import cibertec.dam1.examenfinal.modelo.Heroe;
import cibertec.dam1.examenfinal.utils.Constantes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etCodigo;
    private Button btnBuscar;
    private TextView tvNombreSuperheroe, tvNombreCompletoSuperHeroe, tvAlterEgoSuperHeroe,
            tvInteligenciaSuperHeroe, tvLugNacimientoSuperHeroe, tvPoderSuperHeroe, tvVelocidadSuperHeroe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.etCodigo = findViewById(R.id.etCodigoHeroe);
        this.btnBuscar = findViewById(R.id.btnBuscar);
        this.tvNombreSuperheroe = findViewById(R.id.tvNombreSuperheroe);
        this.tvNombreCompletoSuperHeroe = findViewById(R.id.tvNombreCompletoSuperHeroe);
        this.tvAlterEgoSuperHeroe = findViewById(R.id.tvAlterEgoSuperHeroe);
        this.tvLugNacimientoSuperHeroe = findViewById(R.id.tvLugarNacSuperHeroe);
        this.tvInteligenciaSuperHeroe = findViewById(R.id.tvInteligenciaSuperHeroe);
        this.tvPoderSuperHeroe = findViewById(R.id.tvPoderSuperHeroe);
        this.tvVelocidadSuperHeroe = findViewById(R.id.tvVelocidadSuperHeroe);
        this.btnBuscar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnBuscar){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constantes.BASE_URL + Constantes.SUPERHERO_TOKEN + "/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            SuperHeroInterface service = retrofit.create(SuperHeroInterface.class);
            Call<Heroe> heroe = service.getHero(this.etCodigo.getText().toString());

            heroe.enqueue(new Callback<Heroe>() {
                @Override
                public void onResponse(Call<Heroe> call, Response<Heroe> response) {
                    Heroe h = response.body();
                    //System.out.println(response.toString());
                    System.out.println(h.getName() + " "+ h.getBiografia().getFullName());
                    tvNombreSuperheroe.setText(h.getName());
                    tvNombreCompletoSuperHeroe.setText(h.getBiografia().getFullName());
                    tvAlterEgoSuperHeroe.setText(h.getBiografia().getAlterEgo());
                    tvLugNacimientoSuperHeroe.setText(h.getBiografia().getPlaceOfBirth());
                    tvInteligenciaSuperHeroe.setText(h.getPoderes().getInteligencia());
                    tvPoderSuperHeroe.setText(h.getPoderes().getPoder());
                    tvVelocidadSuperHeroe.setText(h.getPoderes().getVelocidad());
                    //Toast.makeText(MainActivity.this, "se ejecuto correctamente", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<Heroe> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Hubo problemas al ejecutar el servicio", Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
