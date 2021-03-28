package com.cypherstudios.gestionCuenta;

public class Persona {

    private String nombre;
    private String apellidos;
    private String fecha_nac;

    public Persona(String nombre, String apellidos, String fecha_nac) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nac = fecha_nac;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha_nac() {
        return this.fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    @Override
    public String toString() {
        return "\n-+ TITULAR DE LA CUENTA +++-"
                + "\n----------------------------"
                + "\n+ Nombre ................... " + this.nombre
                + "\n+ Apellidos ................ " + this.apellidos
                + "\n+ Fecha de nacimiento: ..... " + this.fecha_nac + "\n";
    }
}
