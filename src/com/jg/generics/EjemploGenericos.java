package com.jg.generics;

import com.jg.interfaces.modelo.Cliente;
import com.jg.interfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        // Lista de clientes para probar el iterator() y next()
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Josue","Garcia"));
        Cliente josue = clientes.iterator().next();

        // Arreglos de diferentes tipos de datos
        Cliente[] clientesArreglo = {
                new Cliente("Josue","Garcia"),
                new Cliente("Lucy","Martinez")
        };

        Integer[] enterosArreglo = {1,2,3};

        System.out.println("=== Utilizando un metodo generico de un parámetro ===");
        // Convertir los arreglos creados a listas
        List<Cliente> clientesLista = fromArrayToList(clientesArreglo);
        List<Integer> enterosLista = fromArrayToList(enterosArreglo);

        // Recorriendo las listas
        clientesLista.forEach(System.out::println);
        enterosLista.forEach(System.out::println);

        System.out.println("=== Utilizando un metodo generico de dos parámetro ===");
        List<String> nombres = fromArrayToList
                (
                new String[]{"Andres","Pepe","Lucy","Bea","John"},
                enterosArreglo
                );
        nombres.forEach(System.out::println);

        //
        List<Cliente> clientesPremium = fromArrayToList(
                new ClientePremium[]{new ClientePremium("Paco","Fernandez")});

        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientesPremium);

        System.out.println("Máximo de 1, 9 y 4 es : " + maximo(1,9,4));
        System.out.println("Maximo de 3.9, 11.6, 7.78 es: " + maximo(3.9, 11.6, 7.78));
        System.out.println("Maximo de zanahoria, arandanos, manzana es: " +
                maximo("zanahoria", "arandanos","manzana"));

    }

    // Un método, ya sea de instancia o de clase puede ser génerico.
    public static <T> List<T> fromArrayToList(T[] t) {
        return Arrays.asList(t);
    }

    // Método limitado a aquellos que sean Number.
    public static <T extends Number> List<T> fromArrayToList(T[] t) {
        return Arrays.asList(t);
    }

    public static <T extends Cliente> List<T> fromArrayToList(T[] t) {
        return Arrays.asList(t);
    }

    // public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] t) {
    //    return Arrays.asList(t);
    // }

    // t --> convertir       g --> iterar
    public static <T, G> List<T> fromArrayToList(T[] t, G[] g) {
        for(G elemento : g) {
            System.out.println(elemento);
        }
        return Arrays.asList(t);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes) {
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }

        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
}
