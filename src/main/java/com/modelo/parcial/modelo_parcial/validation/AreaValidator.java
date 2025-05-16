package com.modelo.parcial.modelo_parcial.validation;

import com.modelo.parcial.modelo_parcial.exception.ConflictoException;
import com.modelo.parcial.modelo_parcial.exception.NoEncontradoException;
import com.modelo.parcial.modelo_parcial.repository.AreaRepository;

public class AreaValidator {
    public static void comprobarAreaExistente(String nombre, AreaRepository areaRepository)
    {
        if(areaRepository.existsByNombre(nombre))
        {
            throw new ConflictoException("Error: El area que se está ingresando ya se encuentra en la base de datos");
        }
    }
    public static void comprobarAreaExistentePorId(Long id, AreaRepository areaRepository)
    {
        if(!(areaRepository.existsById(id)))
        {
            throw new NoEncontradoException("Error: El area no existe");
        }
    }
    public static void comprobarAreaExistentePorNombre(String nombre, AreaRepository areaRepository)
    {
        if(!(areaRepository.existsByNombre(nombre)))
        {
            throw new NoEncontradoException("Error: El area no existe");
        }
    }
}
