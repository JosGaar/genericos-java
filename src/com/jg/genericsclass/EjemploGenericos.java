package com.jg.genericsclass;

public class EjemploGenericos {

    public static <T> void imprimirCamion(Camion<T> camion) {
        for(T a : camion) {
            System.out.println(a);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Transporte de caballos ===");
        Camion<Animal> transCaballos = new Camion<>(5);
        transCaballos.add(new Animal("Pelegrino","Caballo"));
        transCaballos.add(new Animal("Grillo","Caballo"));
        transCaballos.add(new Animal("Tunque","Caballo"));
        transCaballos.add(new Animal("Topocalma", "Caballo"));
        transCaballos.add(new Animal("Longotoma","Caballo"));

        imprimirCamion(transCaballos);

        System.out.println("=== Transporte de maquinarias ===");
        Camion<Maquinaria> transMaquinarias = new Camion<>(3);
        transMaquinarias.add(new Maquinaria("Bull"));
        transMaquinarias.add(new Maquinaria("Grua"));
        transMaquinarias.add(new Maquinaria("Perforadora"));

        imprimirCamion(transMaquinarias);

        System.out.println("=== Transporte de autos ===");
        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("Mitsubishi"));
        transAuto.add(new Automovil("Chevrolet"));

        imprimirCamion(transAuto);
    }
}
