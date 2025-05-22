package com.modelo.parcial.modelo_parcial.service;

import com.modelo.parcial.modelo_parcial.model.Profesor;
import com.modelo.parcial.modelo_parcial.repository.ProfesorRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.modelo.parcial.modelo_parcial.validation.ProfesorValidator.*;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor crearProfesor(Profesor profesor)
    {
        comprobarArea(profesor, profesorRepository);
        comprobarEmail(profesor.getEmail(), profesorRepository);
        return profesorRepository.save(profesor);
    }
    public Optional<Profesor> mostrarPorEmail(String email)
    {
        return profesorRepository.findByEmail(email);
    }
    public Optional<Profesor> modificarProfesor(Long id, Profesor profesor)
    {
        comprobarEmail(profesor.getEmail(), profesorRepository);
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
        comprobarSiExisteId(id, profesorRepository);
        profesorRepository.deleteById(id);
    }

    @Transactional
    public void eliminarProfesorPorEmail(String email)
    {
        comprobarSiExisteEmail(email, profesorRepository);
        profesorRepository.deleteByEmail(email);
    }

}
