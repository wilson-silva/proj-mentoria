package com.estudo.mentoria.controller;

import com.estudo.mentoria.entities.Categoria;
import com.estudo.mentoria.services.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService service;

    //------------------------------------------------------------------------------------------

    @GetMapping
    public ResponseEntity<List<Categoria>> listaTodasCategorias() {
        List<Categoria> categorias = service.listaTodasCategorias();
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

   @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable UUID id) {
        var categoria = service.buscarPorId(id);
        if(categoria.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoria.get());
    }
}