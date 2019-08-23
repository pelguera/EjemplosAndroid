package cibertec.dam1.ejemplolistview.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cibertec.dam1.ejemplolistview.R;
import cibertec.dam1.ejemplolistview.model.Elemento;

public class ElementoAdaptador extends BaseAdapter {

    private Activity actividad;
    private ArrayList<Elemento> elementos;

    public ElementoAdaptador(Activity actividad, ArrayList<Elemento> elementos) {
        super();
        this.actividad = actividad;
        this.elementos = elementos;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int posicion, View vistaACambiar, ViewGroup parent) {
        View vista = vistaACambiar;

        if(vista == null){
            LayoutInflater inflater = (LayoutInflater)actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.lista_elementos_layout, null);
        }

        Elemento elemento = elementos.get(posicion);

        TextView nombre = (TextView)vista.findViewById(R.id.nombre);
        nombre.setText(elemento.getNombre());

        ImageView imagen = (ImageView)vista.findViewById(R.id.imagenElemento);
        //hay que recupera el id de la imagen
        //int recursoImagen = actividad.getResources().getIdentifier("drawable/" + elemento.getImagen(), null, actividad.getPackageName());
        //colocamos la imagen recuperada segun la clase R
        //imagen.setImageDrawable(actividad.getResources().getDrawable(recursoImagen));


        View vista1 = vista;
        return vista1;
    }
}
