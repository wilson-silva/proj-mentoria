package com.estudo.mentoria.domain.services;

import com.estudo.mentoria.api.request.CategoriaRequest;
import com.estudo.mentoria.api.response.CategoriaResponse;
import com.estudo.mentoria.domain.entities.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CategoriaService {

    Page<Categoria> findAll(Pageable pageable);
    Categoria findById(UUID id);
    void save(CategoriaRequest request);
    CategoriaResponse update(UUID id, CategoriaRequest request);
    void delete(UUID id);

}
