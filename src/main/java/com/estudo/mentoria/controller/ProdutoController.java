package com.estudo.mentoria.controller;

import com.estudo.mentoria.entities.Categoria;
import com.estudo.mentoria.entities.Produto;
import com.estudo.mentoria.services.CategoriaService;
import com.estudo.mentoria.services.ProdutoService;
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
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    //------------------------------------------------------------------------------------------

    @GetMapping
    public ResponseEntity<List<Produto>> listaTodosProdutos() {
        List<Produto> produtos = service.listaTodosProdutos();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

   @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable UUID id) {
        var produto = service.buscarPorId(id);
        if(produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto.get());
    }
}