package com.estudo.mentoria.controller;

import com.estudo.mentoria.mapper.ProdutoMapper;
import com.estudo.mentoria.dto.produto.ProdutoRequestDto;
import com.estudo.mentoria.dto.produto.ProdutoResponseDto;
import com.estudo.mentoria.services.ProdutoService;
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
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ProdutoMapper mapper;

    @GetMapping
    public ResponseEntity<Page<ProdutoResponseDto>> listarTodosProdutos(Pageable pageable) {
        return ResponseEntity.ok(produtoService.findAll(pageable).map(mapper::toProdutoResponse));
    }

    @GetMapping("/buscar")
    public ResponseEntity<Page<ProdutoResponseDto>> listarTodosProdutosComCriterio(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String descricao,
            @RequestParam(required = false) String categoriaTitulo,
            @RequestParam(required = false) String fabricante,
            Pageable pageable) {
        return ResponseEntity.ok(produtoService.filtraProdutosPorCriterios(nome, descricao, categoriaTitulo, fabricante, pageable).map(mapper::toProdutoResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> buscarProduto(@PathVariable UUID id) {
        return ResponseEntity.ok(mapper.toProdutoResponse(produtoService.findById(id)));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> cadastrarProduto(@RequestBody @Valid ProdutoRequestDto request) {
        var produto = mapper.toProduto(request);
        produtoService.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> alterarProduto(@PathVariable("id") UUID id,
                                                 @RequestBody @Valid ProdutoRequestDto request) {
        var produto = mapper.toProduto(request);
        var savedProduto = produtoService.update(id, produto);
        mapper.toProdutoResponse(savedProduto);
        return ResponseEntity.ok("Dados atualizados com sucesso!");
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> excluirProduto(@PathVariable UUID id) {
        produtoService.delete(id);
        return ResponseEntity.ok("Produto excluído (estado atualizado).");
    }
}


