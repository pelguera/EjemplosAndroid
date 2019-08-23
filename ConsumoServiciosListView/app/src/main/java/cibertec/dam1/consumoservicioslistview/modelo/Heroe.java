package cibertec.dam1.consumoservicioslistview.modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Heroe {

    private String id;
    private String name;
    @SerializedName("biography")
    private HeroeBiografia biografia;

    public Heroe(String id, String name, HeroeBiografia biografia) {
        this.id = id;
        this.name = name;
        this.biografia = biografia;
    }

    public HeroeBiografia getBiografia() {
        return biografia;
    }

    public void setBiografia(HeroeBiografia biografia) {
        this.biografia = biografia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static HeroeBiografia parseJSON(String response){
        Gson gson = new GsonBuilder().create();
        HeroeBiografia bio = gson.fromJson(response, HeroeBiografia.class);
        return bio;
    }
}
