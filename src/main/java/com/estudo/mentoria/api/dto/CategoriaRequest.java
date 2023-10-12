package com.estudo.mentoria.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequest {

    @NotBlank(message = "O titulo e obrigatorio")
    private String titulo;
}
