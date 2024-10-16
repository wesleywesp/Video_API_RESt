package com.Wesleywesp.Videos_APi_REST.repository;

import com.Wesleywesp.Videos_APi_REST.domain.categoria.Categoria;
import com.Wesleywesp.Videos_APi_REST.domain.categoria.CategoriaEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByCategoriaEnum(CategoriaEnum categoriaEnum);

    @Query("SELECT c FROM Categoria c JOIN c.videos v WHERE c.id = :id ORDER BY v.titulo")
    Categoria findByIdCaracteristica(@Param("id") Long id);
}
