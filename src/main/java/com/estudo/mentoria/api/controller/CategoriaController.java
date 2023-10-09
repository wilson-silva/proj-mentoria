package com.estudo.mentoria.api.controller;

import com.estudo.mentoria.api.mapper.CategoriaMapper;
import com.estudo.mentoria.api.request.CategoriaRequest;
import com.estudo.mentoria.api.response.CategoriaResponse;
import com.estudo.mentoria.domain.services.serviceImpl.CategoriaServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaServiceImpl service;
    private final CategoriaMapper mapper;

    @GetMapping
    public ResponseEntity<Page<CategoriaResponse>> listarTodasCategorias(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable).map(mapper::toCategoriaResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> buscarCategoria(@PathVariable Long id){
        return ResponseEntity.ok(mapper.toCategoriaResponse(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<String> cadastrarCategoria(@RequestBody @Valid CategoriaRequest request){
        service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterarCategoria(@PathVariable("id") Long id,
                                                   @RequestBody @Valid CategoriaRequest request){
        service.update(id, request);
        return ResponseEntity.ok("Dados atualizados com sucesso!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> excluirCategoria(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Categoria excluída (estado atualizado).");
    }


}