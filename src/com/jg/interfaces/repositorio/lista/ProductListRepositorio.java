package com.jg.interfaces.repositorio.lista;

import com.jg.interfaces.modelo.Producto;
import com.jg.interfaces.repositorio.AbstractListRepositorio;
import com.jg.interfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductListRepositorio extends AbstractListRepositorio<Producto> {

    @Override
    public void editar(Producto producto) {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);

        listaOrdenada.sort((a, b) -> {
            int resultado = 0;

            if (dir == Direccion.ASC) {
                resultado = ProductListRepositorio.ordenar(a,b, campo);
            } else if (dir == Direccion.DESC) {
                resultado = ProductListRepositorio.ordenar(b,a, campo);
            }
            return resultado;
        });

        return listaOrdenada;
    }

    public static int ordenar(Producto a, Producto b, String campo) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "descripcion" -> resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" -> resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }
}
