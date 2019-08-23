package com.pelme.ejemplotabs.utils;

import com.pelme.ejemplotabs.modelo.Pais;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Pais> getPaises(){
        return new ArrayList<Pais>(){
            {
                add(new Pais("España", "ES"));
                add(new Pais("Argentina", "AR"));
                add(new Pais("Bolivia", "BO"));
                add(new Pais("Chile", "CL"));
                add(new Pais("Colombia", "CO"));
                add(new Pais("Ecuador", "EC"));
                add(new Pais("Mexico", "MX"));
                add(new Pais("Perú", "PE"));
                add(new Pais("Uruguay", "UY"));
                add(new Pais("Venezuela", "VE"));
            }
        };
    }

    public static final String URL_FOTO_PAIS = "http://www.geognos.com/api/en/countries/flag/";
}
