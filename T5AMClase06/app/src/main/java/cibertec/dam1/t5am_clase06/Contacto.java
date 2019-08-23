package cibertec.dam1.t5am_clase06;

public class Contacto {

    private String nombre;
    private String estado;
    private String nombreFoto;

    public Contacto(String nombre, String estado, String nombreFoto) {
        this.nombre = nombre;
        this.estado = estado;
        this.nombreFoto = nombreFoto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreFoto() {
        return nombreFoto;
    }

    public void setNombreFoto(String nombreFoto) {
        this.nombreFoto = nombreFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
