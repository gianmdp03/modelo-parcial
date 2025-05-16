package com.modelo.parcial.modelo_parcial.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.HashSet;
import java.util.Set;

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1)
    @Column(nullable = false)
    private Integer duracionSemanas;

    @Min(1)
    @Column(nullable = false)
    private Integer cupoMaximo;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @OneToMany(mappedBy = "curso")
    private Set<Inscripcion> inscripciones = new HashSet<>();

    public Curso() {
    }

    public Curso(Integer cupoMaximo, Integer duracionSemanas, Set<Inscripcion> inscripciones, Profesor profesor) {
        this.cupoMaximo = cupoMaximo;
        this.duracionSemanas = duracionSemanas;
        this.inscripciones = inscripciones;
        this.profesor = profesor;
    }

    public Curso(Long id) {
        this.id = id;
    }

    public Integer getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(Integer cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public Integer getDuracionSemanas() {
        return duracionSemanas;
    }

    public void setDuracionSemanas(Integer duracionSemanas) {
        this.duracionSemanas = duracionSemanas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Set<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(Set<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
}
