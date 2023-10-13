package com.estudo.mentoria.api.controller;

import com.estudo.mentoria.api.mapper.ProdutoMapper;
import com.estudo.mentoria.api.dto.ProdutoRequest;
import com.estudo.mentoria.api.dto.ProdutoResponse;
import com.estudo.mentoria.domain.services.ProdutoService;
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

    private final ProdutoService produtoService;
    private final ProdutoMapper mapper;

    @GetMapping
    public ResponseEntity<Page<ProdutoResponse>> listarTodosProdutos(Pageable pageable) {
        return ResponseEntity.ok(produtoService.findAll(pageable).map(mapper::toProdutoResponse));
    }

    @GetMapping("/buscar")
    public ResponseEntity<Page<ProdutoResponse>> listarTodosProdutosComCriterio(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) String categoriaTitulo,
            @RequestParam(required = false) String fabricante,
            Pageable pageable) {
        return ResponseEntity.ok(produtoService.filtraProdutosPorCriterios(nome, descricao, categoriaTitulo, fabricante, pageable).map(mapper::toProdutoResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarProduto(@PathVariable UUID id) {
        return ResponseEntity.ok(mapper.toProdutoResponse(produtoService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<String> cadastrarProduto(@RequestBody @Valid ProdutoRequest request) {
        var produto = mapper.toProduto(request);
        produtoService.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterarProduto(@PathVariable("id") UUID id,
                                                 @RequestBody @Valid ProdutoRequest request) {
        var produto = mapper.toProduto(request);
        var savedProduto = produtoService.update(id, produto);
        mapper.toProdutoResponse(savedProduto);
        return ResponseEntity.ok("Dados atualizados com sucesso!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> excluirProduto(@PathVariable UUID id) {
        produtoService.delete(id);
        return ResponseEntity.ok("Produto excluído (estado atualizado).");
    }
}


