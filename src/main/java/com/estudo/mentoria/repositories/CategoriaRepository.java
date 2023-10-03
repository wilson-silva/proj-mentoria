package com.estudo.mentoria.repositories;

import com.estudo.mentoria.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {


}
