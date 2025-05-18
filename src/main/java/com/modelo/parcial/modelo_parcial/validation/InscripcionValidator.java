package com.modelo.parcial.modelo_parcial.validation;

import com.modelo.parcial.modelo_parcial.exception.ConflictoException;
import com.modelo.parcial.modelo_parcial.exception.NoEncontradoException;
import com.modelo.parcial.modelo_parcial.model.Alumno;
import com.modelo.parcial.modelo_parcial.model.Curso;
import com.modelo.parcial.modelo_parcial.model.Inscripcion;
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
    public static void comprobarEmailAlumnoYCurso(String email, Curso curso, InscripcionRepository inscripcionRepository)
    {
        if(!(inscripcionRepository.existsByAlumnoEmailAndCurso(email, curso)))
        {
            throw new NoEncontradoException("Error: El email o el curso ingresado no existen");
        }
    }
    public static void validarCupo(Inscripcion inscripcion, InscripcionRepository inscripcionRepository)
    {
        if(inscripcionRepository.count()>=inscripcion.getCurso().getCupoMaximo())
        {
            throw new ConflictoException("Error: Este curso ya alcanzó su cupo máximo");
        }
    }
}
