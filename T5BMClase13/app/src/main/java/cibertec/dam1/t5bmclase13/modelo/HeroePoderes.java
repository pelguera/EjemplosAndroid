package cibertec.dam1.t5bmclase13.modelo;

import com.google.gson.annotations.SerializedName;

public class HeroePoderes {

    @SerializedName("intelligence")
    private String inteligencia;

    private String strength;

    private String speed;

    @SerializedName("durability")
    private String durabilidad;

    @SerializedName("power")
    private String poder;

    private String combat;

    public HeroePoderes(String inteligencia, String strength, String speed, String durabilidad, String poder, String combat) {
        this.inteligencia = inteligencia;
        this.strength = strength;
        this.speed = speed;
        this.durabilidad = durabilidad;
        this.poder = poder;
        this.combat = combat;
    }

    public String getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(String inteligencia) {
        this.inteligencia = inteligencia;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDurabilidad() {
        return durabilidad;
    }

    public void setDurabilidad(String durabilidad) {
        this.durabilidad = durabilidad;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getCombat() {
        return combat;
    }

    public void setCombat(String combat) {
        this.combat = combat;
    }
}
