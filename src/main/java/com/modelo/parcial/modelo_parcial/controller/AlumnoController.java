package com.modelo.parcial.modelo_parcial.controller;

import com.modelo.parcial.modelo_parcial.model.Alumno;
import com.modelo.parcial.modelo_parcial.service.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumno")
@Validated
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;
/*
{
    "nombre": "Lucas",
    "apellido": "Rodriguez",
    "email": "lucasrodriguez@hotmail.com",
    "fichaMedica": {
        "observacion" : "Esta perfecto"
    }
}

 */
    @PostMapping
    public ResponseEntity<Alumno> crearAlumno(@Valid @RequestBody Alumno alumno)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.crearAlumno(alumno));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Optional<Alumno>> modificarAlumno(@PathVariable Long id, @Valid @RequestBody Alumno alumno)
    {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.modificarAlumno(id, alumno));
    }
    @GetMapping
    public ResponseEntity<List<Alumno>> listarAlumnos()
    {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.listarAlumnos());
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<Alumno>> mostrarPorEmail(@PathVariable String email)
    {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.mostrarPorEmail(email));
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id)
    {
        alumnoService.eliminarAlumno(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping("/email/{email}")
    public ResponseEntity<Void> eliminarAlumnoPorEmail(@PathVariable String email)
    {
        alumnoService.eliminarAlumnoPorEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
