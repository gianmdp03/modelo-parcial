package com.modelo.parcial.modelo_parcial.repository;

import com.modelo.parcial.modelo_parcial.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    boolean existsByEmail(String email);
    void deleteByEmail(String email);
    Optional<Profesor> findByEmail(String email);
}
