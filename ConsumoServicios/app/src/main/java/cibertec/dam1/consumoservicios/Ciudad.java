package cibertec.dam1.consumoservicios;

import com.google.gson.annotations.Expose;

public class Ciudad {

    @Expose
    private int id;
    private String name;


    public Ciudad() {
    }

    public Ciudad(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
