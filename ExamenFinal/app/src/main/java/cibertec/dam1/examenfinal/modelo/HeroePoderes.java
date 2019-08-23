package cibertec.dam1.examenfinal.modelo;

import com.google.gson.annotations.SerializedName;

public class HeroePoderes {

    @SerializedName("intelligence")
    private String inteligencia;

    @SerializedName("speed")
    private String velocidad;

    @SerializedName("power")
    private String poder;

    public String getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(String inteligencia) {
        this.inteligencia = inteligencia;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }
}
