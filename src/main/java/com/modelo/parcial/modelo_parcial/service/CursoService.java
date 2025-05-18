package com.modelo.parcial.modelo_parcial.service;

import com.modelo.parcial.modelo_parcial.model.Curso;
import com.modelo.parcial.modelo_parcial.repository.CursoRepository;
import com.modelo.parcial.modelo_parcial.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import static com.modelo.parcial.modelo_parcial.validation.ProfesorValidator.*;
import static com.modelo.parcial.modelo_parcial.validation.CursoValidator.*;
@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private ProfesorRepository profesorRepository;
    public Curso crearCurso(Curso curso)
    {
        comprobarProfesor(curso, cursoRepository);
        return cursoRepository.save(curso);
    }

    public Optional<Curso> modificarCurso(Long id, Curso curso)
    {
        comprobarSiExisteId(id, cursoRepository);
        return cursoRepository.findById(id).map(existing -> {
           existing.setCupoMaximo(curso.getCupoMaximo());
           existing.setDuracionSemanas(curso.getDuracionSemanas());
           return cursoRepository.save(existing);
        });
    }

    public List<Curso> listarCurso()
    {
        return cursoRepository.findAll();
    }

    public List<Curso> filtrarPorProfesor(String email)
    {
        comprobarSiExisteEmail(email, profesorRepository);
        return cursoRepository.findByProfesorEmail(email);
    }
    public void eliminarCurso(Long id)
    {
        comprobarSiExisteId(id, cursoRepository);
        cursoRepository.deleteById(id);
    }
}
