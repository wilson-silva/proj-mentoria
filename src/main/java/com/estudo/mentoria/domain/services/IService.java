package com.estudo.mentoria.domain.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface IService<T> {
    
    Page<T> findAll(Pageable pageable);
    T findById(UUID id);
    void save(T t);
    T update(UUID id, T request);
    void delete(UUID id);
}
