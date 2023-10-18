package com.estudo.mentoria.repositories;


import com.estudo.mentoria.entities.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
    boolean existsByTitulo(String titulo);
    boolean existsById(UUID id);
    @Query(value = "SELECT * FROM tb_categoria c where c.estado = 1;", nativeQuery = true)
    Page<Categoria> buscarCategoriaEstadoTrue(Pageable pageable);
}
