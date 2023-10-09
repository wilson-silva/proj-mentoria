package com.estudo.mentoria.domain.repositories;

import com.estudo.mentoria.domain.entities.Categoria;
import com.estudo.mentoria.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {



}
