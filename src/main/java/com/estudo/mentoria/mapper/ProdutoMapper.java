package com.estudo.mentoria.mapper;

import com.estudo.mentoria.dto.produto.ProdutoRequestDto;
import com.estudo.mentoria.dto.produto.ProdutoResponseDto;
import com.estudo.mentoria.entities.Produto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProdutoMapper {
    private final ModelMapper mapper;

    public Produto toProduto(ProdutoRequestDto produtoRequestDto) {
        return mapper.map(produtoRequestDto, Produto.class);
    }
    public ProdutoResponseDto toProdutoResponse(Produto produto) {
        return mapper.map(produto, ProdutoResponseDto.class);
    }

    public List<ProdutoResponseDto> toProdutoResponseList(List<Produto> produtos) {
        return produtos.stream()
                .map(this::toProdutoResponse)
                .toList();
    }
}
