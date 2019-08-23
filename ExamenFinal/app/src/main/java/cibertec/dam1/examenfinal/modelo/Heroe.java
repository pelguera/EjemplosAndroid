package cibertec.dam1.examenfinal.modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Heroe {

    private String id;
    private String name;
    @SerializedName("biography")
    private HeroeBiografia biografia;
    @SerializedName("powerstats")
    private HeroePoderes poderes;

    public HeroePoderes getPoderes() {
        return poderes;
    }

    public void setPoderes(HeroePoderes poderes) {
        this.poderes = poderes;
    }

    public Heroe(String id, String name, HeroeBiografia biografia, HeroePoderes poderes) {
        this.id = id;
        this.name = name;
        this.biografia = biografia;
        this.poderes = poderes;
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

    public static HeroePoderes parseJSONPoderes(String response){
        Gson gson = new GsonBuilder().create();
        HeroePoderes power = gson.fromJson(response, HeroePoderes.class);
        return power;
    }
}
