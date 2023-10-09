package com.estudo.mentoria.domain.services.serviceImpl;

import com.estudo.mentoria.api.request.ProdutoRequest;
import com.estudo.mentoria.api.response.ProdutoResponse;
import com.estudo.mentoria.domain.entities.Produto;
import com.estudo.mentoria.domain.repositories.ProdutoRepository;
import com.estudo.mentoria.domain.services.ProdutoService;
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
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;
    private final ModelMapper mapper;

    @Override
    public Page<Produto> findAll(Pageable pageable) {
        return repository.buscarProdutoEstadoTrue(pageable);
    }

    @Override
    public Produto findById(UUID id) {
        return repository.findById(id)
                .filter(Produto::getEstado)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado ou excluído!"));
    }

    @Override
    public void save(ProdutoRequest request) {
        var produto = mapper.map(request, Produto.class);
        if (existeNome(request.getNome())) {
            throw new BadRequestException("Produto já existe");
        }
        repository.save(produto);
    }

    public boolean existeNome(String nome) {
        return repository.existsByNome(nome);
    }

    @Override
    public ProdutoResponse update(UUID id, ProdutoRequest request) {
        var produto = findById(id);
        mapper.map(request, produto);
        repository.save(produto);
        return mapper.map(produto, ProdutoResponse.class);
    }

    @Override
    public void delete(UUID id) {
        Produto produto = findById(id);
        produto.setEstado(false);
        repository.save(produto);
    }
}





