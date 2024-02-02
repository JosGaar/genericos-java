package com.jg.interfaces;

import com.jg.interfaces.modelo.Cliente;
import com.jg.interfaces.repositorio.*;
import com.jg.interfaces.repositorio.lista.ClientListRepositorio;

import java.util.List;

public class EjemploRepositorioCliente {
    public static void main(String[] args) {

        FullRepositorio<Cliente> repo = new ClientListRepositorio();
        repo.crear(new Cliente("Jano", "Perez"));
        repo.crear(new Cliente("Bea", "Gonzales"));
        repo.crear(new Cliente("Josue", "Garcia"));
        repo.crear(new Cliente("Andres", "Guzman"));

        System.out.println("=== Listando ===");
        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);

        System.out.println("\n=== Paginable ===");
        List<Cliente> paginable = repo.listar(1, 3);
        paginable.forEach(System.out::println);

        System.out.println("\n=== Orden ===");
        List<Cliente> clientesOrdenAsc = repo.listar("nombre", Direccion.ASC);
        clientesOrdenAsc.forEach(System.out::println);

        System.out.println("\n=== Editar ===");
        Cliente beaActualizar = new Cliente("Bea", "Mena");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);
        Cliente bea = repo.porId(2);
        System.out.println(bea);

        System.out.println("\n=== Eliminar ===");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        System.out.println("\n=== Total repositorio===");
        System.out.println(repo.total());

    }
}
