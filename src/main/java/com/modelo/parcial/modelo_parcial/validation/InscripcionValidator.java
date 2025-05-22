package com.modelo.parcial.modelo_parcial.validation;

import com.modelo.parcial.modelo_parcial.exception.ConflictoException;
import com.modelo.parcial.modelo_parcial.exception.NoEncontradoException;
import com.modelo.parcial.modelo_parcial.model.Alumno;
import com.modelo.parcial.modelo_parcial.model.Curso;
import com.modelo.parcial.modelo_parcial.model.Inscripcion;
import com.modelo.parcial.modelo_parcial.repository.CursoRepository;
import com.modelo.parcial.modelo_parcial.repository.InscripcionRepository;

public class InscripcionValidator {
    public static void comprobarAlumnoInscripto(Alumno alumno, Curso curso, InscripcionRepository inscripcionRepository)
    {
        if(inscripcionRepository.existsByAlumnoAndCurso(alumno, curso))
        {
            throw new ConflictoException("Error: El alumno ya está inscripto a este curso");
        }
    }
    public static void comprobarIdCurso(Long id, InscripcionRepository inscripcionRepository)
    {
        if(!(inscripcionRepository.existsById(id)))
        {
            throw new NoEncontradoException("Error: El ID ingresado no existe");
        }
    }

    public static void validarCupo(Inscripcion inscripcion, InscripcionRepository inscripcionRepository, CursoRepository cursoRepository)
    {
        Curso curso = cursoRepository.getReferenceById(inscripcion.getCurso().getId());
        Long inscriptos = inscripcionRepository.countByCursoId(inscripcion.getCurso().getId());
        if(inscriptos>=curso.getCupoMaximo())
        {
            throw new ConflictoException("Error: Cupo Maximo");
        }
    }
}
