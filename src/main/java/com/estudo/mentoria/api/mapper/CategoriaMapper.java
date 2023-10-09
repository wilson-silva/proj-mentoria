package com.estudo.mentoria.api.mapper;

import com.estudo.mentoria.api.request.CategoriaRequest;
import com.estudo.mentoria.api.response.CategoriaResponse;
import com.estudo.mentoria.domain.entities.Categoria;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriaMapper {
    private final ModelMapper mapper;

    public Categoria toCategoria(CategoriaRequest request) {
        return mapper.map(request, Categoria.class);
    }

    public CategoriaResponse toCategoriaResponse(Categoria categoria) {
        return mapper.map(categoria, CategoriaResponse.class);
    }

    public List<CategoriaResponse> toCategoriaResponseList(List<Categoria> categorias) {
        return categorias.stream()
                .map(this::toCategoriaResponse)
                .toList();
    }
}
