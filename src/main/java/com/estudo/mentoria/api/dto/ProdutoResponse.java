package com.estudo.mentoria.api.dto;

import com.estudo.mentoria.api.dto.CategoriaResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {

    private String idproduto;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer estoque;
    @JsonIgnore
    private Boolean estado = true;
    private String fabricante;
    @JsonIgnore
    private CategoriaResponse categoria;
    public String getCategoriaTitulo() {
        return categoria != null ? categoria.getTitulo() : null;
    }
}