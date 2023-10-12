package com.estudo.mentoria.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idproduto;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer estoque;
    private Boolean estado = true;
    private String fabricante;
    @ManyToOne//(fetch = FetchType.EAGER)
    private Categoria categoria;
}
