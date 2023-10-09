package com.estudo.mentoria.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

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
    private CategoriaResponse categoria;

}
