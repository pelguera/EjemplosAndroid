package com.example.admin.t5bmsemana3.dao;

import com.example.admin.t5bmsemana3.R;
import com.example.admin.t5bmsemana3.beans.CiudadBean;

import java.util.ArrayList;

/**
 * Created by admin on 03/09/2016.
 */
public class CiudadDAO {
    public ArrayList<CiudadBean> ListaCiudad(String idpais){
        ArrayList<CiudadBean> ciudades=
                new ArrayList<CiudadBean>();
        CiudadBean bean;


        bean=new CiudadBean();
        bean.setIdciu("0");
        bean.setNomciu("--Seleccione--");
        ciudades.add(bean);

        if(idpais.equals("PE")){
            bean=new CiudadBean();
            bean.setIdciu("TU");
            bean.setNomciu("TUMBES");
            bean.setObservacion("Las playas de tumbes");
            bean.setWeb("http://www.google.com");
            bean.setIdpais("PE");
            bean.setFoto(R.drawable.tumbes);
            ciudades.add(bean);
            bean=new CiudadBean();
            bean.setIdciu("CU");
            bean.setNomciu("CUZCO");
            bean.setObservacion("Machupichu");
            bean.setWeb("http://www.outlook.com");
            bean.setIdpais("PE");
            bean.setFoto(R.drawable.cuzco);
            ciudades.add(bean);
        }else{
            bean=new CiudadBean();
            bean.setIdciu("AC");
            bean.setNomciu("ACAPULCO");
            bean.setObservacion("Las playas de acapulco");
            bean.setWeb("http://www.gmail.com");
            bean.setIdpais("MX");
            bean.setFoto(R.drawable.acapulco);
            ciudades.add(bean);
        }

        return ciudades;
    }
}
