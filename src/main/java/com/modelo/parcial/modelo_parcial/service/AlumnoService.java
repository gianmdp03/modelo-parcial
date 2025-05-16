package com.modelo.parcial.modelo_parcial.service;

import com.modelo.parcial.modelo_parcial.model.Alumno;
import com.modelo.parcial.modelo_parcial.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.modelo.parcial.modelo_parcial.validation.AlumnoValidator.*;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public Alumno crearAlumno(Alumno alumno)
    {
        comprobarEmail(alumno.getEmail(), alumnoRepository);
        return alumnoRepository.save(alumno);
    }

    public Optional<Alumno> modificarAlumno(Long id, Alumno alumno)
    {
        comprobarEmail(alumno.getEmail(), alumnoRepository);
        return alumnoRepository.findById(id).map(existing -> {
            existing.setNombre(alumno.getNombre());
            existing.setApellido(alumno.getApellido());
            existing.setEmail(alumno.getEmail());
            return alumnoRepository.save(existing);
        });
    }

    public List<Alumno> listarAlumnos()
    {
        return alumnoRepository.findAll();
    }

    public void eliminarAlumno(Long id)
    {
        comprobarSiExisteId(id, alumnoRepository);
        alumnoRepository.deleteById(id);
    }

    public void eliminarAlumnoPorEmail(String email)
    {
        comprobarSiExisteEmail(email, alumnoRepository);
        alumnoRepository.deleteByEmail(email);
    }
}
