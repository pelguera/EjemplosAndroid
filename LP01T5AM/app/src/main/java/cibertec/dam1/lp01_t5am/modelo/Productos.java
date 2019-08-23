package cibertec.dam1.lp01_t5am.modelo;

public class Productos {

    private String  id;
    private String nombreImagen;

    public String getNombreProducto() {
        return nombreProducto;
    }

    public Productos(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String nombreProducto;

    public Productos(String id, String nombreImagen, String tipoProducto, String nroProducto, String precio) {
        this.id = id;
        this.nombreImagen = nombreImagen;
        this.tipoProducto = tipoProducto;
        this.nroProducto = nroProducto;
        this.precio = precio;
    }

    private String tipoProducto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getNroProducto() {
        return nroProducto;
    }

    public void setNroProducto(String nroProducto) {
        this.nroProducto = nroProducto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    private String nroProducto;
    private String  precio;



}
