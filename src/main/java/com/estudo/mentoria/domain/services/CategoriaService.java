package com.estudo.mentoria.domain.services;

import com.estudo.mentoria.api.request.CategoriaRequest;
import com.estudo.mentoria.api.response.CategoriaResponse;
import com.estudo.mentoria.domain.entities.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoriaService {

    Page<Categoria> findAll(Pageable pageable);
    Categoria findById(Long id);
    void save(CategoriaRequest request);
    CategoriaResponse update(Long id, CategoriaRequest request);
    void delete(Long id);

}
