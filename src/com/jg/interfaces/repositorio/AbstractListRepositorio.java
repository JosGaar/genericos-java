package com.jg.interfaces.repositorio;

import com.jg.interfaces.modelo.BaseEntity;
import com.jg.interfaces.repositorio.exepciones.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListRepositorio<T extends BaseEntity>
        implements FullRepositorio<T> {

    protected List<T> dataSource;

    public AbstractListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return this.dataSource;
    }

    @Override
    public T porId(Integer id) throws AccesoDatosException {

        if (id == null ||  id <= 0) {
            throw new LecturaAccesoDatosException("Id invalido.");
        }

        T resultado = null;

        for(T obj : this.dataSource) {
            if (obj.getId() != null && obj.getId().equals(id)) {
                resultado = obj;
                break;
            }
        }

        if (resultado == null) {
            throw new LecturaAccesoDatosException("No existe el registro con id: " + id);
        }

        return resultado;
    }

    @Override
    public void crear(T t) throws AccesoDatosException {

        if (t == null) {
            throw new EscrituraAccesoDatosException("Error al insetar un objeto null");
        }

        if (this.dataSource.contains(t)) {
            throw new RegistroDuplicadoAccesoDatoException
                    ("Error el objeto con id: " + t.getId() + " ya existe.");
        }

        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws AccesoDatosException {
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return this.dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
