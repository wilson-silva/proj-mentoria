package com.estudo.mentoria.domain.repositories;

import com.estudo.mentoria.domain.entities.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
    boolean existsByTitulo(String titulo);

    boolean existsById(UUID id);

    @Query(value = "SELECT * FROM categoria c where c.estado = 1;", nativeQuery = true)
    Page<Categoria> buscarCategoriaEstadoTrue(Pageable pageable);

}
