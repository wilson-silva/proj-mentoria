package com.estudo.mentoria.api.mapper;

import com.estudo.mentoria.api.request.ProdutoRequest;
import com.estudo.mentoria.api.response.ProdutoResponse;
import com.estudo.mentoria.domain.entities.Produto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProdutoMapper {
    private final ModelMapper mapper;

    public Produto toProduto(ProdutoRequest request) {
        return mapper.map(request, Produto.class);
    }

    public ProdutoResponse toProdutoResponse(Produto produto) {
        return mapper.map(produto, ProdutoResponse.class);
    }

    public List<ProdutoResponse> toProdutoResponseList(List<Produto> produtos) {
        return produtos.stream()
                .map(this::toProdutoResponse)
                .toList();
    }
}
