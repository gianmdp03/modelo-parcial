package com.modelo.parcial.modelo_parcial.repository;

import com.modelo.parcial.modelo_parcial.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    void deleteByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Alumno> findByEmail(String email);
}
