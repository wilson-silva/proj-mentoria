package com.estudo.mentoria.api.controller;

import com.estudo.mentoria.api.mapper.CategoriaMapper;
import com.estudo.mentoria.api.dto.CategoriaRequest;
import com.estudo.mentoria.api.dto.CategoriaResponse;
import com.estudo.mentoria.domain.entities.Categoria;
import com.estudo.mentoria.domain.services.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;

    @GetMapping
    public ResponseEntity<Page<CategoriaResponse>> listarTodasCategorias(Pageable pageable){
        return ResponseEntity.ok(categoriaService.findAll(pageable).map(categoriaMapper::toCategoriaResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> buscarCategoria(@PathVariable UUID id){
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.ok(categoriaMapper.toCategoriaResponse(categoria));
    }

    @PostMapping
    public ResponseEntity<String> cadastrarCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest){
        Categoria categoria = categoriaMapper.toCategoria(categoriaRequest);
        categoriaService.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterarCategoria(@PathVariable("id") UUID id, @RequestBody @Valid CategoriaRequest categoriaRequest){
        Categoria categoria = categoriaMapper.toCategoria(categoriaRequest);
        Categoria categoriaSalva = categoriaService.update(id, categoria);
        categoriaMapper.toCategoriaResponse(categoriaSalva);
        return ResponseEntity.ok("Dados atualizados com sucesso!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> excluirCategoria(@PathVariable UUID id) {
        categoriaService.delete(id);
        return ResponseEntity.ok("Categoria excluída (estado atualizado).");
    }
}