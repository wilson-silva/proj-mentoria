package com.estudo.mentoria.mapper;

import com.estudo.mentoria.dto.categoria.CategoriaRequestDto;
import com.estudo.mentoria.dto.categoria.CategoriaResponseDto;
import com.estudo.mentoria.entities.Categoria;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriaMapper {
    private final ModelMapper mapper;

    public Categoria toCategoria(CategoriaRequestDto categoriaRequestDto) {
        return mapper.map(categoriaRequestDto, Categoria.class);
    }

    public CategoriaResponseDto toCategoriaResponse(Categoria categoria) {
        return mapper.map(categoria, CategoriaResponseDto.class);
    }

    public List<CategoriaResponseDto> toCategoriaResponseList(List<Categoria> categorias) {
        return categorias.stream()
                .map(this::toCategoriaResponse)
                .toList();
    }
}
