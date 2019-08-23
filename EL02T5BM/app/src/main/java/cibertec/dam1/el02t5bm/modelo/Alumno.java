package cibertec.dam1.el02t5bm.modelo;

public class Alumno {

    private int id;
    private String nombre;
    private String apellido;
    private String nivel;
    private String grado;

    public Alumno(String nombre, String apellido, String nivel, String grado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nivel = nivel;
        this.grado = grado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
}
