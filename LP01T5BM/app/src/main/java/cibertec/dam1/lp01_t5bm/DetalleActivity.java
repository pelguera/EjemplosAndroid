package cibertec.dam1.lp01_t5bm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    /*
    1.- Declarar como variables los componentes del activity_detalle que sean necesarios
     */


    private TextView tvid, tvnombreImagen, tvnombres, tvapellidos, tvsexo, tvdocumento, tvnroDocumento, tvtelefono, tvemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*
        2.- Inicializar los componentes del activity_detalle que han sido declarados en el paso 1
        3.- Obtener el objeto Bundle del Intent
        4.- Asignar los valores obtenidos del objeto Bundle a los componentes respectivos
        5.- Para mostrar la foto apoyarse en estas dos lineas de codigo

            int idFoto = this.getResources().getIdentifier(bundle.getString("nombreFoto"), "mipmap", getPackageName());
            this.ivDetalleFoto.setImageResource(idFoto);

            Reemplazar el "nombreFoto" y ivDetalleFoto por los nombres que hayan puesto en sus proyectos
         */

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);


        this.initComponents();
        Bundle bundle = getIntent().getExtras();


        tvnombres.setText(bundle.getString("nombre"));
        tvapellidos.setText(bundle.getString("apellido"));
        tvsexo.setText(bundle.getString("sexo"));
        tvdocumento.setText(bundle.getString("documento"));
        tvnroDocumento.setText(bundle.getString("nroD"));
        tvtelefono.setText(bundle.getString("telefono"));
        tvemail.setText(bundle.getString("email"));


    }

    public void initComponents(){
        this.tvnombres = findViewById(R.id.tvNombre);
        this.tvapellidos = findViewById(R.id.tvapellido);
        this.tvsexo = findViewById(R.id.tvSexo);
        this.tvdocumento = findViewById(R.id.tvDocIdent);
        this.tvnroDocumento = findViewById(R.id.tvNroDoc);
        this.tvtelefono = findViewById(R.id.tvTelefono);
        this.tvemail = findViewById(R.id.tvEmail);

    }
}
