package com.estudo.mentoria.api.request;

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
