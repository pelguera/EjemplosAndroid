package cibertec.dam1.clase03.cibertec.dami1.clase03.dto;

public class ProformaAuto {

    private String nombreCliente;
    private String direccionCliente;
    private String distritoCliente;
    private String autoCliente;
    private boolean aplicaDsctoCliente;
    private boolean incluirIgvCliente;
    private double precioAuto;
    private double descuentoAuto;
    private double igvAuto;
    private double subTotalAuto;
    private double totalAuto;

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getDistritoCliente() {
        return distritoCliente;
    }

    public void setDistritoCliente(String distritoCliente) {
        this.distritoCliente = distritoCliente;
    }

    public String getAutoCliente() {
        return autoCliente;
    }

    public void setAutoCliente(String autoCliente) {
        this.autoCliente = autoCliente;
    }

    public boolean isAplicaDsctoCliente() {
        return aplicaDsctoCliente;
    }

    public void setAplicaDsctoCliente(boolean aplicaDsctoCliente) {
        this.aplicaDsctoCliente = aplicaDsctoCliente;
    }

    public boolean isIncluirIgvCliente() {
        return incluirIgvCliente;
    }

    public void setIncluirIgvCliente(boolean incluirIgvCliente) {
        this.incluirIgvCliente = incluirIgvCliente;
    }

    public double getPrecioAuto() {
        return precioAuto;
    }

    public void setPrecioAuto(double precioAuto) {
        this.precioAuto = precioAuto;
    }

    public double getDescuentoAuto() {
        return descuentoAuto;
    }

    public void setDescuentoAuto(double descuentoAuto) {
        this.descuentoAuto = descuentoAuto;
    }

    public double getIgvAuto() {
        return igvAuto;
    }

    public void setIgvAuto(double igvAuto) {
        this.igvAuto = igvAuto;
    }

    public double getSubTotalAuto() {
        return subTotalAuto;
    }

    public void setSubTotalAuto(double subTotalAuto) {
        this.subTotalAuto = subTotalAuto;
    }

    public double getTotalAuto() {
        return totalAuto;
    }

    public void setTotalAuto(double totalAuto) {
        this.totalAuto = totalAuto;
    }
}
