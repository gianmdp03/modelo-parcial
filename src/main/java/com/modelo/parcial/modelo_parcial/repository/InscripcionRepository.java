package com.modelo.parcial.modelo_parcial.repository;

import com.modelo.parcial.modelo_parcial.model.Alumno;
import com.modelo.parcial.modelo_parcial.model.Curso;
import com.modelo.parcial.modelo_parcial.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    boolean existsByAlumnoAndCurso(Alumno alumno, Curso curso);
    Long countByCursoId(Long id);
}
