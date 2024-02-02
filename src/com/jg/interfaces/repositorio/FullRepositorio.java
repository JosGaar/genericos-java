package com.jg.interfaces.repositorio;

public interface FullRepositorio<T> extends
        OrdenableRepositorio<T>, PaginableRepositorio<T>, CrudRepositorio<T>, ContableRepositorio {
}
