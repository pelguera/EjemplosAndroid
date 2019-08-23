package com.example.admin.t5bmsemana3.beans;

/**
 * Created by admin on 03/09/2016.
 */
public class CiudadBean {
    private String idciu;
    private String nomciu;
    private String observacion;
    private String web;
    private int foto;
    private String idpais;

    public String toString(){
        return nomciu;
    }

    public String getIdciu() {
        return idciu;
    }

    public void setIdciu(String idciu) {
        this.idciu = idciu;
    }

    public String getNomciu() {
        return nomciu;
    }

    public void setNomciu(String nomciu) {
        this.nomciu = nomciu;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getIdpais() {
        return idpais;
    }

    public void setIdpais(String idpais) {
        this.idpais = idpais;
    }
}
