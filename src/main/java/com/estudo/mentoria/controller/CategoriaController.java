package com.estudo.mentoria.controller;

import com.estudo.mentoria.dto.categoria.CategoriaRequestDto;
import com.estudo.mentoria.dto.categoria.CategoriaResponseDto;
import com.estudo.mentoria.entities.Categoria;
import com.estudo.mentoria.mapper.CategoriaMapper;
import com.estudo.mentoria.services.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;

    @GetMapping
    public ResponseEntity<Page<CategoriaResponseDto>> listarTodasCategorias(Pageable pageable){
        return ResponseEntity.ok(categoriaService.findAll(pageable).map(categoriaMapper::toCategoriaResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDto> buscarCategoria(@PathVariable UUID id){
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.ok(categoriaMapper.toCategoriaResponse(categoria));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> cadastrarCategoria(@RequestBody @Valid CategoriaRequestDto categoriaRequestDto){
        Categoria categoria = categoriaMapper.toCategoria(categoriaRequestDto);
        categoriaService.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> alterarCategoria(@PathVariable("id") UUID id, @RequestBody @Valid CategoriaRequestDto categoriaRequestDto){
        Categoria categoria = categoriaMapper.toCategoria(categoriaRequestDto);
        Categoria categoriaSalva = categoriaService.update(id, categoria);
        categoriaMapper.toCategoriaResponse(categoriaSalva);
        return ResponseEntity.ok("Dados atualizados com sucesso!");
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> excluirCategoria(@PathVariable UUID id) {
        categoriaService.delete(id);
        return ResponseEntity.ok("Categoria excluída (estado atualizado).");
    }
}