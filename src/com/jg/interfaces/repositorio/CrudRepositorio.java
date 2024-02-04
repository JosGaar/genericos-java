package com.jg.interfaces.repositorio;

import com.jg.interfaces.repositorio.exepciones.AccesoDatosException;

import java.util.List;

public interface CrudRepositorio<T> {

    List<T> listar();
    T porId(Integer id) throws AccesoDatosException;
    void crear(T obj) throws AccesoDatosException;
    void editar(T obj) throws AccesoDatosException;
    void eliminar(Integer id) throws AccesoDatosException;
}
