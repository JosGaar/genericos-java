package com.jg.interfaces;

import com.jg.interfaces.modelo.Cliente;
import com.jg.interfaces.modelo.Producto;
import com.jg.interfaces.repositorio.Direccion;
import com.jg.interfaces.repositorio.FullRepositorio;
import com.jg.interfaces.repositorio.lista.ProductListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {

        FullRepositorio<Producto> repo = new ProductListRepositorio();
        repo.crear(new Producto("mesa", 50.52));
        repo.crear(new Producto("silla", 18));
        repo.crear(new Producto("lampara", 15.5));
        repo.crear(new Producto("notebook", 400.49));

        System.out.println("=== Listando ===");
        List<Producto> productos = repo.listar();
        productos.forEach(System.out::println);

        System.out.println("\n=== Paginable ===");
        List<Producto> paginable = repo.listar(1, 3);
        paginable.forEach(System.out::println);

        System.out.println("\n=== Orden ===");
        List<Producto> productosOrdenAsc = repo.listar("descripcion", Direccion.ASC);
        productosOrdenAsc.forEach(System.out::println);

        System.out.println("\n=== Editar ===");
        Producto lamparaActualizar = new Producto("lampara escritorio", 23);
        lamparaActualizar.setId(3);
        repo.editar(lamparaActualizar);
        Producto lam = repo.porId(3);
        System.out.println(lam);

        System.out.println("\n=== Eliminar ===");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        System.out.println("\n=== Total repositorio ===");
        System.out.println(repo.total());

    }
}
