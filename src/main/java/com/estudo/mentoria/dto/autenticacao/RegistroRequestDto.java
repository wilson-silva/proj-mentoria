package com.estudo.mentoria.dto.autenticacao;

import com.estudo.mentoria.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroRequestDto {

    private String username;
    private String password;
    private UserRole role;
}
