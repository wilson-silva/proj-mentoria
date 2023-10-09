package com.estudo.mentoria.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequest {

    @NotBlank(message = "O nome e obrigatorio")
    @Size(min = 3, max = 50)
    private String nome;

    @NotBlank(message = "A descrição e obrigatorio")
    @Size(min = 2, max = 100)
    private String descricao;

    @NotNull(message = "O preço e obrigatorio")
    @Digits(integer = 10, fraction = 2)
    private Double preco;

    @NotNull
    private Integer estoque;

    @NotBlank(message = "O fabricante e obrigatorio")
    @Size(min = 2, max = 100)
    private String fabricante;

    @NotNull
    private Long categoriaId;


}
