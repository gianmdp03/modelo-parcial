package com.modelo.parcial.modelo_parcial.service;

import com.modelo.parcial.modelo_parcial.model.Alumno;
import com.modelo.parcial.modelo_parcial.model.Curso;
import com.modelo.parcial.modelo_parcial.model.Inscripcion;
import com.modelo.parcial.modelo_parcial.repository.CursoRepository;
import com.modelo.parcial.modelo_parcial.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

import static com.modelo.parcial.modelo_parcial.validation.InscripcionValidator.*;
@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Autowired
    private CursoRepository cursoRepository;
    public Inscripcion crearInscripion(Inscripcion inscripcion)
    {
        validarCupo(inscripcion, inscripcionRepository, cursoRepository);
        comprobarAlumnoInscripto(inscripcion.getAlumno(), inscripcion.getCurso(), inscripcionRepository);
        return inscripcionRepository.save(inscripcion);
    }
    public void eliminarInscripcionPorId(Long id)
    {
        comprobarIdCurso(id, inscripcionRepository);
        inscripcionRepository.deleteById(id);
    }
    public List<Inscripcion> listarInscripciones()
    {
        return inscripcionRepository.findAll();
    }
    public Optional<Inscripcion> mostrarPorId(Long id)
    {
        return inscripcionRepository.findById(id);
    }
}
