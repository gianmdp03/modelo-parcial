package com.modelo.parcial.modelo_parcial.controller;

import com.modelo.parcial.modelo_parcial.model.Inscripcion;
import com.modelo.parcial.modelo_parcial.service.InscripcionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripcion")
@Validated
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;
    @PostMapping
    public ResponseEntity<Inscripcion> crearInscripcion(@Valid @RequestBody Inscripcion inscripcion)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(inscripcionService.crearInscripion(inscripcion));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> eliminarInscripcion(@PathVariable Long id)
    {
        inscripcionService.eliminarInscripcionPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
