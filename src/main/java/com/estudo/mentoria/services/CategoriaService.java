package com.estudo.mentoria.services;

import com.estudo.mentoria.entities.Categoria;
import com.estudo.mentoria.repositories.CategoriaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;

    public List<Categoria> listaTodasCategorias(){
        if(repository.findAll().isEmpty()){
            throw new RuntimeException("lista de categoria vazia!");
        }
        return repository.findAll();
    }

    public Optional<Categoria> buscarPorId(UUID id){
        return repository.findById(id);
    }
}
