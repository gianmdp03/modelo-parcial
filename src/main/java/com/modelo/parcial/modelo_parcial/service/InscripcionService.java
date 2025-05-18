package com.modelo.parcial.modelo_parcial.service;

import com.modelo.parcial.modelo_parcial.model.Alumno;
import com.modelo.parcial.modelo_parcial.model.Curso;
import com.modelo.parcial.modelo_parcial.model.Inscripcion;
import com.modelo.parcial.modelo_parcial.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.modelo.parcial.modelo_parcial.validation.InscripcionValidator.*;
@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;

    public Inscripcion crearInscripion(Inscripcion inscripcion)
    {
        comprobarAlumnoInscripto(inscripcion.getAlumno(), inscripcion.getCurso(), inscripcionRepository);
        return inscripcionRepository.save(inscripcion);
    }
    public void eliminarInscripcionPorId(Long id)
    {
        comprobarIdCurso(id, inscripcionRepository);
        inscripcionRepository.deleteById(id);
    }

    public void eliminarInscripcionPorEmailAlumnoYCurso(String email, Curso curso)
    {
        comprobarEmailAlumnoYCurso(email, curso, inscripcionRepository);
        inscripcionRepository.deleteByAlumnoEmailAndCurso(email, curso);
    }

}
