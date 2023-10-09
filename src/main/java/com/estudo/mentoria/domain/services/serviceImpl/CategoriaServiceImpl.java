package com.estudo.mentoria.domain.services.serviceImpl;

import com.estudo.mentoria.api.request.CategoriaRequest;
import com.estudo.mentoria.api.response.CategoriaResponse;
import com.estudo.mentoria.domain.entities.Categoria;
import com.estudo.mentoria.domain.repositories.CategoriaRepository;
import com.estudo.mentoria.domain.services.CategoriaService;
import com.estudo.mentoria.exception.BadRequestException;
import com.estudo.mentoria.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;
    private final ModelMapper mapper;

    @Override
    public Page<Categoria> findAll(Pageable pageable) {
        return repository.buscarCategoriaEstadoTrue(pageable);
    }

    @Override
    public Categoria findById(Long id) {
        return repository.findById(id)
                .filter(Categoria::getEstado)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada ou excluída!"));
    }


    @Override
    public void save(CategoriaRequest request) {
        var categoria = mapper.map(request, Categoria.class);
        if (existeTitulo(request.getTitulo())) {
            throw new BadRequestException("Categoria já existe");
        }
        repository.save(categoria);
    }

    public boolean existeTitulo(String titulo) {
        return repository.existsByTitulo(titulo);
    }

    @Override
    public CategoriaResponse update(Long id, CategoriaRequest request) {
        var categoria = findById(id);
        mapper.map(request, categoria);
        repository.save(categoria);
        return mapper.map(categoria, CategoriaResponse.class);
    }

    @Override
    public void delete(Long id) {
        Categoria categoria = findById(id);
        categoria.setEstado(false);
        repository.save(categoria);
    }
}





