package com.estudo.mentoria.dto.autenticacao;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutenticacaoRequestDto {

    @NotBlank(message = "O username e obrigatorio")
    private String username;
    @NotBlank(message = "A password e obrigatorio")
    private String password;
}
