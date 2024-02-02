package com.jg.genericsclass;

public class Animal {

    private String nombre;
    private String tipo;

    public Animal(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\n" +
                "Tipo: " + this.tipo;
    }

}

