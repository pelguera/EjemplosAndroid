package com.example.admin.t5bmsemana3.dao;

import com.example.admin.t5bmsemana3.beans.PaisBean;

import java.util.ArrayList;

/**
 * Created by admin on 03/09/2016.
 */
public class PaisDAO {
    public ArrayList<PaisBean> ListaPais(){
        ArrayList<PaisBean> paises=
                new ArrayList<PaisBean>();
        PaisBean bean;


        bean=new PaisBean();
        bean.setIdpais("0");
        bean.setDespais("--Seleccione--");
        paises.add(bean);

        bean=new PaisBean();
        bean.setIdpais("PE");
        bean.setDespais("PERU");
        paises.add(bean);
        bean=new PaisBean();
        bean.setIdpais("MX");
        bean.setDespais("MEXICO");
        paises.add(bean);
        return paises;
    }



}
