package com.modelo.parcial.modelo_parcial.controller;

import com.modelo.parcial.modelo_parcial.model.Curso;
import com.modelo.parcial.modelo_parcial.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
@Validated
public class CursoController {
    @Autowired
    private CursoService cursoService;
    @PostMapping
    public ResponseEntity<Curso> crearCurso(@Valid @RequestBody Curso curso)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.crearCurso(curso));
    }
    @PutMapping
    public ResponseEntity<Optional<Curso>> modificarCurso(@PathVariable Long id, @Valid @RequestBody Curso curso)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.modificarCurso(id, curso));
    }
    @GetMapping
    public ResponseEntity<List<Curso>> listarCurso()
    {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.listarCurso());
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<List<Curso>> filtrarPorProfesor(@Valid @PathVariable String email)
    {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.filtrarPorProfesor(email));
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id)
    {
        cursoService.eliminarCurso(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
