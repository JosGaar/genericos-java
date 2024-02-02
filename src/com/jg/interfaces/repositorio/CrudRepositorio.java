package com.jg.interfaces.repositorio;

import java.util.List;

public interface CrudRepositorio<T> {

    List<T> listar();
    T porId(Integer id);
    void crear(T obj);
    void editar(T obj);
    void eliminar(Integer id);
}
