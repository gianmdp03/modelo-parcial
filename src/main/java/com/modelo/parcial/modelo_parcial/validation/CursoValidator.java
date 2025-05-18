package com.modelo.parcial.modelo_parcial.validation;

import com.modelo.parcial.modelo_parcial.exception.NoEncontradoException;
import com.modelo.parcial.modelo_parcial.exception.BadRequestException;
import com.modelo.parcial.modelo_parcial.model.Curso;
import com.modelo.parcial.modelo_parcial.repository.CursoRepository;

public class CursoValidator {
    public static void comprobarSiExisteId(Long id, CursoRepository cursoRepository)
    {
        if(!(cursoRepository.existsById(id)))
        {
            throw new NoEncontradoException("Error: El id ingresado no existe");
        }
    }
    public static void comprobarProfesor(Curso curso, CursoRepository cursoRepository)
    {
        if(curso.getProfesor() == null)
        {
            throw new BadRequestException("Error: No se ingresó un profesor para este curso");
        }
    }
}
