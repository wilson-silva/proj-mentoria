package com.estudo.mentoria.api.mapper;

import com.estudo.mentoria.api.dto.ProdutoRequest;
import com.estudo.mentoria.api.dto.ProdutoResponse;
import com.estudo.mentoria.domain.entities.Produto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProdutoMapper {
    private final ModelMapper mapper;

    public Produto toProduto(ProdutoRequest produtoRequest) {
        return mapper.map(produtoRequest, Produto.class);
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
