package com.example.admin.t5bmsemana4.dao;

import com.example.admin.t5bmsemana4.bean.LibroBean;

import java.util.ArrayList;

public class LibroDAO {
    public ArrayList<LibroBean> ListadoLibros(){
        ArrayList<LibroBean> libros=
                new ArrayList<LibroBean>();
        LibroBean bean;
        bean=new LibroBean();
        bean.setIdlibro("L1");
        bean.setNombre("LA BIBLIA DEL SQL");
        bean.setAutor("JUAN MENDO");
        bean.setPortada("sql");
        libros.add(bean);

        bean=new LibroBean();
        bean.setIdlibro("L2");
        bean.setNombre("EL MUNDO DE JAVA");
        bean.setAutor("MARIO SALAS");
        bean.setPortada("java");
        libros.add(bean);

        bean=new LibroBean();
        bean.setIdlibro("L3");
        bean.setNombre("VISUAL BASIC");
        bean.setAutor("DORIS TORRES");
        bean.setPortada("vb");
        libros.add(bean);
        return libros;
    }
}
