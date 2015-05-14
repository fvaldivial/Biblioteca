package pe.arq.bean;

import java.util.List;

public class UsuarioBean {

    private String dni;
    private String nombre;
    private String tipo;
    //0 admin, 1 usuario

    public UsuarioBean(String dni, String nombre, String tipo) {
        this.dni = dni;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public UsuarioBean() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

}
