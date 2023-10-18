package com.estudo.mentoria.dto.categoria;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponseDto {

    private String id;
    private String titulo;
    @JsonIgnore
    private Boolean estado;
}
