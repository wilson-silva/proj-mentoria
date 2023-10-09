package com.estudo.mentoria.domain.services.serviceImpl;

import com.estudo.mentoria.api.request.CategoriaRequest;
import com.estudo.mentoria.api.response.CategoriaResponse;
import com.estudo.mentoria.domain.entities.Categoria;
import com.estudo.mentoria.domain.repositories.CategoriaRepository;
import com.estudo.mentoria.domain.services.CategoriaService;
import com.estudo.mentoria.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;
    private final ModelMapper mapper;


    @Override
    public Page<Categoria> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Categoria findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Colaborador não encontrado!"));
    }

    @Override
    public Categoria save(CategoriaRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public CategoriaResponse update(UUID id, CategoriaRequest request) {
        return null;
    }


}
