package com.modelo.parcial.modelo_parcial.validation;

import com.modelo.parcial.modelo_parcial.exception.BadRequestException;
import com.modelo.parcial.modelo_parcial.exception.ConflictoException;
import com.modelo.parcial.modelo_parcial.exception.NoEncontradoException;
import com.modelo.parcial.modelo_parcial.model.Alumno;
import com.modelo.parcial.modelo_parcial.repository.AlumnoRepository;

public class AlumnoValidator {
    public static void comprobarSiExisteEmail(String email, AlumnoRepository alumnoRepository)
    {
        if(!(alumnoRepository.existsByEmail(email)))
        {
            throw new NoEncontradoException("Error: El email ingresado no corresponde a un alumno");
        }
    }

    public static void comprobarSiExisteId(Long id, AlumnoRepository alumnoRepository)
    {
        if(!(alumnoRepository.existsById(id)))
        {
            throw new NoEncontradoException("Error: El id ingresado no corresponde a un alumno");
        }
    }

    public static void comprobarEmail(String email, AlumnoRepository alumnoRepository)
    {
        if(alumnoRepository.existsByEmail(email))
        {
            throw new ConflictoException("Error: El email ingresado ya existe");
        }
    }

    public static void comprobarFichaMedica(Alumno alumno, AlumnoRepository alumnoRepository)
    {
        if(alumno.getFichaMedica() == null)
        {
            throw new BadRequestException("Error: No se ingresó la ficha médica del alumno");
        }
    }
}
