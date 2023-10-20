package com.estudo.mentoria.controller;

import com.estudo.mentoria.dto.autenticacao.AutenticacaoRequestDto;
import com.estudo.mentoria.dto.autenticacao.RegistroRequestDto;
import com.estudo.mentoria.dto.autenticacao.TokenResponseDto;
import com.estudo.mentoria.entities.Usuario;
import com.estudo.mentoria.exception.BadRequestException;
import com.estudo.mentoria.repositories.UsuarioRepository;
import com.estudo.mentoria.services.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("autenticar")
@RequiredArgsConstructor
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoRequestDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new TokenResponseDto(token));
    }

    @PostMapping("/registrar")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> registrar(@RequestBody @Valid RegistroRequestDto data) {
        if (this.usuarioRepository.findByUsername(data.getUsername()) != null) {
            throw new BadRequestException("Username já está em uso");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        Usuario usuario = new Usuario(data.getUsername(), encryptedPassword, data.getRole());
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }
}
