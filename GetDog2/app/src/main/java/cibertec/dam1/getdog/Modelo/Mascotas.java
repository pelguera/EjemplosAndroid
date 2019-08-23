package cibertec.dam1.getdog.Modelo;

public class Mascotas {

    private String nombre;
    private String descripcion;
    private String genero;
    private String raza;
    private String tamaño;
    private String color;
    private String direccion;
    private String estado;
    private String fecha;
    private String nombreFoto;




    public Mascotas(String nombre, String descripcion, String genero, String raza, String tamaño, String color, String direccion, String estado, String fecha, String nombreFoto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.genero = genero;
        this.raza = raza;
        this.tamaño = tamaño;
        this.color = color;
        this.direccion = direccion;
        this.estado = estado;
        this.fecha=fecha;
        this.nombreFoto = nombreFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getFecha() { return fecha; }

    public void setFecha(String fecha) { this.fecha = fecha; }
}
