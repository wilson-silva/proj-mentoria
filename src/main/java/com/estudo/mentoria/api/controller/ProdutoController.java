package com.estudo.mentoria.api.controller;

import com.estudo.mentoria.api.mapper.ProdutoMapper;
import com.estudo.mentoria.api.request.ProdutoRequest;
import com.estudo.mentoria.api.response.ProdutoResponse;
import com.estudo.mentoria.domain.services.serviceImpl.ProdutoServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoServiceImpl service;
    private final ProdutoMapper mapper;

    @GetMapping
    public ResponseEntity<Page<ProdutoResponse>> listarTodosProdutos(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable).map(mapper::toProdutoResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarProduto(@PathVariable UUID id) {
        return ResponseEntity.ok(mapper.toProdutoResponse(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<String> cadastrarProduto(@RequestBody @Valid ProdutoRequest request) {
        service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterarProduto(@PathVariable("id") UUID id,
                                                 @RequestBody @Valid ProdutoRequest request) {
        service.update(id, request);
        return ResponseEntity.ok("Dados atualizados com sucesso!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> excluirProduto(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.ok("Produto excluído (estado atualizado).");
    }
}


