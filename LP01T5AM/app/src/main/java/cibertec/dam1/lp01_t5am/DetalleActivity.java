package cibertec.dam1.lp01_t5am;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cibertec.dam1.lp01_t5am.R;

public class DetalleActivity extends AppCompatActivity {

    /*
    1.- Declarar como variables los componentes del activity_detalle que sean necesarios

    */

    public int id,tipoproducto,nrostock,precio;

    public String nombreImagen,nombreProducto,TipoProducto

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        /*
        2.- Inicializar los componentes del activity_detalle que han sido declarados en el paso 1

        
        3.- Obtener el objeto Bundle del Intent
        4.- Asignar los valores obtenidos del objeto Bundle a los componentes respectivos
        5.- Para mostrar la foto apoyarse en estas dos lineas de codigo

            int idFoto = this.getResources().getIdentifier(bundle.getString("nombreFoto"), "mipmap", getPackageName());
            this.ivDetalleFoto.setImageResource(idFoto);

            Reemplazar el "nombreFoto" y ivDetalleFoto por los nombres que hayan puesto en sus proyectos
         */

    }
}
