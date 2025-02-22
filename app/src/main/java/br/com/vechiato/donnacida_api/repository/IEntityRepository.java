package br.com.vechiato.donnacida_api.repository;


import java.util.List;
import java.util.Optional;

public interface IEntityRepository<T> {

    Optional<T> findById(String identification);

    Optional<T> save(T entity);

    void delete(T entity);

    String ensureSetId(T entity);
}
