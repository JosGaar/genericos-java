package com.jg.interfaces;

import com.jg.interfaces.modelo.Cliente;
import com.jg.interfaces.repositorio.*;
import com.jg.interfaces.repositorio.exepciones.AccesoDatosException;
import com.jg.interfaces.repositorio.exepciones.EscrituraAccesoDatosException;
import com.jg.interfaces.repositorio.exepciones.LecturaAccesoDatosException;
import com.jg.interfaces.repositorio.exepciones.RegistroDuplicadoAccesoDatoException;
import com.jg.interfaces.repositorio.lista.ClientListRepositorio;

import java.util.List;

public class EjemploRepositorioCliente {
    public static void main(String[] args) {

        try {
            FullRepositorio<Cliente> repo = new ClientListRepositorio();
            repo.crear(new Cliente("Jano", "Perez"));
            repo.crear(new Cliente("Bea", "Gonzales"));
            repo.crear(new Cliente("Josue", "Garcia"));

            Cliente andres = new Cliente("Andres", "Guzman");
            repo.crear(andres); // Excepcion de id repetido.
            repo.crear(andres);

            // repo.crear(null); // Lanzar excepción EscrituraAccesoDatosException

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
            repo.eliminar(50); // Lanzando la excepción
            repo.listar().forEach(System.out::println);

            System.out.println("\n=== Total repositorio===");
            System.out.println(repo.total());

            // Se ponen las excepciones más específicas a la más general.
        } catch (RegistroDuplicadoAccesoDatoException e) {
            System.err.println("Registro duplicado:" + e.getMessage());
            e.printStackTrace(System.err);

        } catch (LecturaAccesoDatosException e) {
            System.err.println("Lectura:" + e.getMessage());
            e.printStackTrace(System.err);

        } catch(EscrituraAccesoDatosException e) {
            System.err.println("Escritura: " + e.getMessage());
            e.printStackTrace(System.err);

        } catch (AccesoDatosException e) {
            System.err.println("Generica: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}
