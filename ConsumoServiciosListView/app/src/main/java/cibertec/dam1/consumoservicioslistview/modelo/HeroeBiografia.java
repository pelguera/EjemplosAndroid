package cibertec.dam1.consumoservicioslistview.modelo;

import com.google.gson.annotations.SerializedName;

public class HeroeBiografia {

    @SerializedName("full-name")
    private String fullName;
    @SerializedName("alter-egos")
    private String alterEgo;
    @SerializedName("place-of-birth")
    private String placeOfBirth;

    public HeroeBiografia(String fullName, String alterEgo, String placeOfBirth) {
        this.fullName = fullName;
        this.alterEgo = alterEgo;
        this.placeOfBirth = placeOfBirth;
    }

    public HeroeBiografia() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public void setAlterEgo(String alterEgo) {
        this.alterEgo = alterEgo;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }
}
