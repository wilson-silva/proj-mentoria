package com.estudo.mentoria.domain.services;

import com.estudo.mentoria.domain.entities.Produto;
import com.estudo.mentoria.domain.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public List<Produto> listaTodosProdutos(){
        if(repository.findAll().isEmpty()){
            throw new RuntimeException("lista de produtos vazia!");
        }
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(UUID id){
        return repository.findById(id);
    }
}
