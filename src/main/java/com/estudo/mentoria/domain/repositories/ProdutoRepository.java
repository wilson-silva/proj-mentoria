package com.estudo.mentoria.domain.repositories;

import com.estudo.mentoria.domain.entities.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    boolean existsByNome(String nome);

    @Query(value = "SELECT * FROM produto p where p.estado = 1;", nativeQuery = true)
    Page<Produto> buscarProdutoEstadoTrue(Pageable pageable);

    Page<Produto> findByNomeContainingOrDescricaoContainingOrCategoriaTituloContainingOrFabricanteContaining(
            String nome, String descricao, String categoriaTitulo, String fabricante,  Pageable pageable);
}
