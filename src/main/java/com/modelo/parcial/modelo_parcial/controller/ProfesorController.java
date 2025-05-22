package com.modelo.parcial.modelo_parcial.controller;

import com.modelo.parcial.modelo_parcial.model.Profesor;
import com.modelo.parcial.modelo_parcial.service.ProfesorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesor")
@Validated
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@Valid @RequestBody Profesor profesor)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.crearProfesor(profesor));
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<Profesor>> mostrarPorEmail(@PathVariable String email)
    {
        return ResponseEntity.status(HttpStatus.OK).body(profesorService.mostrarPorEmail(email));
    }
    @GetMapping
    public ResponseEntity<List<Profesor>> listarProfesores()
    {
        return ResponseEntity.status(HttpStatus.OK).body(profesorService.listarProfesores());
    }
    @PutMapping("/id/{id}")
    public ResponseEntity<Optional<Profesor>> modificarProfesor(@PathVariable Long id, @Valid @RequestBody Profesor profesor)
    {
        return ResponseEntity.status(HttpStatus.OK).body(profesorService.modificarProfesor(id, profesor));
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> eliminarProfesorPorId(@PathVariable Long id)
    {
        profesorService.eliminarProfesorPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping("/email/{email}")
    public ResponseEntity<Void> eliminarProfesorPorEmail(@PathVariable String email)
    {
        profesorService.eliminarProfesorPorEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
