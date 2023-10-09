package com.estudo.mentoria.api.controller;

import com.estudo.mentoria.api.mapper.CategoriaMapper;
import com.estudo.mentoria.api.response.CategoriaResponse;
import com.estudo.mentoria.domain.services.serviceImpl.CategoriaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public ResponseEntity<CategoriaResponse> buscarCategoria(@PathVariable UUID id){
        return ResponseEntity.ok(mapper.toCategoriaResponse(service.findById(id)));
    }


}