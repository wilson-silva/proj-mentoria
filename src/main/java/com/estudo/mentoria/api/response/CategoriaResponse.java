package com.estudo.mentoria.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponse {
    private UUID idcategoria;
    private String titulo;
    private Boolean estado;
}
