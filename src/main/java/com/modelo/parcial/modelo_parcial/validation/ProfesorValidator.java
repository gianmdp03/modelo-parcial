package com.modelo.parcial.modelo_parcial.validation;

import com.modelo.parcial.modelo_parcial.exception.BadRequestException;
import com.modelo.parcial.modelo_parcial.exception.ConflictoException;
import com.modelo.parcial.modelo_parcial.exception.NoEncontradoException;
import com.modelo.parcial.modelo_parcial.model.Profesor;
import com.modelo.parcial.modelo_parcial.repository.ProfesorRepository;

public class ProfesorValidator {
    public static void comprobarSiExisteEmail(String email, ProfesorRepository profesorRepository)
    {
        if(!(profesorRepository.existsByEmail(email)))
        {
            throw new NoEncontradoException("Error: El mail no existe");
        }
    }
    public static void comprobarSiExisteId(Long id, ProfesorRepository profesorRepository)
    {
        if(!(profesorRepository.existsById(id)))
        {
            throw new NoEncontradoException("Error: El ID no existe");
        }
    }

    public static void comprobarEmail(String email, ProfesorRepository profesorRepository)
    {
        if(profesorRepository.existsByEmail(email))
        {
            throw new ConflictoException("Error: El email ingresado ya existe");
        }
    }

    public static void comprobarArea(Profesor profesor, ProfesorRepository profesorRepository)
    {
        if(profesor.getArea() == null)
        {
            throw new BadRequestException("Error: No se ingresó un Área Academica para este profesor");
        }
    }
}
