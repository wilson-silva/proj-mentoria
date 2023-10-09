package com.estudo.mentoria.domain.repositories;

import com.estudo.mentoria.domain.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
    boolean existsByTitulo(String titulo);

}
