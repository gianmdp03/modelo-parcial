package com.modelo.parcial.modelo_parcial.repository;

import com.modelo.parcial.modelo_parcial.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    void deleteByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
