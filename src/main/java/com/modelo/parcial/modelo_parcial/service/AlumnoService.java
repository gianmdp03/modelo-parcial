package com.modelo.parcial.modelo_parcial.service;

import com.modelo.parcial.modelo_parcial.model.Alumno;
import com.modelo.parcial.modelo_parcial.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.modelo.parcial.modelo_parcial.validation.AlumnoValidator.*;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public Alumno crearAlumno(Alumno alumno)
    {
        comprobarFichaMedica(alumno, alumnoRepository);
        comprobarEmail(alumno.getEmail(), alumnoRepository);
        return alumnoRepository.save(alumno);
    }

    public Optional<Alumno> modificarAlumno(Long id, Alumno alumno)
    {
        comprobarSiExisteId(id, alumnoRepository);
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
    public Optional<Alumno> mostrarPorEmail(String email)
    {
        return alumnoRepository.findByEmail(email);
    }
    public void eliminarAlumno(Long id)
    {
        comprobarSiExisteId(id, alumnoRepository);
        alumnoRepository.deleteById(id);
    }

    @Transactional
    public void eliminarAlumnoPorEmail(String email)
    {
        comprobarSiExisteEmail(email, alumnoRepository);
        alumnoRepository.deleteByEmail(email);
    }
}
