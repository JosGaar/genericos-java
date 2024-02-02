package com.jg.interfaces.repositorio;

import com.jg.interfaces.modelo.BaseEntity;

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
    public T porId(Integer id) {
        T resultado = null;

        for(T obj : this.dataSource) {
            if (obj.getId() != null && obj.getId().equals(id)) {
                resultado = obj;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) {
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
