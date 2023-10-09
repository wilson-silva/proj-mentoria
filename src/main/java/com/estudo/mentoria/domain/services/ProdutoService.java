package com.estudo.mentoria.domain.services;

import com.estudo.mentoria.api.request.ProdutoRequest;
import com.estudo.mentoria.api.response.ProdutoResponse;
import com.estudo.mentoria.domain.entities.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProdutoService {

    Page<Produto> findAll(Pageable pageable);
    Produto findById(UUID id);
    void save(ProdutoRequest request);
    ProdutoResponse update(UUID id, ProdutoRequest request);
    void delete(UUID id);

}
