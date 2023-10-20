package com.estudo.mentoria.dto.categoria;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequestDto {

    @NotBlank(message = "O titulo e obrigatório")
    private String titulo;
}
