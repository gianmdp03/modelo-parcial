package com.modelo.parcial.modelo_parcial.service;

import com.modelo.parcial.modelo_parcial.model.Profesor;
import com.modelo.parcial.modelo_parcial.repository.ProfesorRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor crearProfesor(Profesor profesor)
    {
        return profesorRepository.save(profesor);
    }

    public Optional<Profesor> modificarProfesor(Long id, Profesor profesor)
    {
        return profesorRepository.findById(id).map(existing -> {
            existing.setNombre(profesor.getNombre());
            existing.setApellido(profesor.getApellido());
            existing.setEmail(profesor.getEmail());
            return profesorRepository.save(existing);
        });
    }

    public List<Profesor> listarProfesores()
    {
        return profesorRepository.findAll();
    }

    public void eliminarProfesorPorId(Long id)
    {
        profesorRepository.deleteById(id);
    }

}
