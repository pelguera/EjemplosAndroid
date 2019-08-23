package cibertec.dam1.conexionbd.modelos;

public class Cliente {

    private int id;
    private String name;
    private String telf;
    private String mail;

    public Cliente() {}

    public Cliente(String name, String telf, String mail) {
        this.name = name;
        this.telf = telf;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telf='" + telf + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

}
