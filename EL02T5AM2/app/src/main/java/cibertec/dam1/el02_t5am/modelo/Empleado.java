package cibertec.dam1.el02_t5am.modelo;

public class Empleado {

    private int id;
    private String nombre;
    private String apellido;
    private String area;
    private String cargo;

    public Empleado(String nombre, String apellido, String area, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.area = area;
        this.cargo = cargo;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
