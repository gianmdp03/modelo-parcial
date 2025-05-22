package com.modelo.parcial.modelo_parcial.controller;

import com.modelo.parcial.modelo_parcial.model.Area;
import com.modelo.parcial.modelo_parcial.service.AreaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
@Validated
public class AreaController {
    @Autowired
    private AreaService areaService;

    @PostMapping
    public ResponseEntity<Area> crearArea(@Valid @RequestBody Area area)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(areaService.crearArea(area));
    }

    @GetMapping
    public ResponseEntity<List<Area>> listarArea()
    {
        return ResponseEntity.status(HttpStatus.OK).body(areaService.listarArea());
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id)
    {
        areaService.eliminarAreaPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/nombre/{nombre}")
    public ResponseEntity<Void> eliminarPorNombre(@PathVariable String nombre)
    {
        areaService.eliminarAreaPorNombre(nombre);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
