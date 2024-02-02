package com.jg.genericsclass;

public class Maquinaria {

    private String tipo;

    public Maquinaria(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Tipo: " + this.tipo;
    }
}
