package com.modelo.parcial.modelo_parcial.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Table(name = "fichas_medicas")
@Entity
public class FichaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(columnDefinition = "TEXT", nullable = false)
    private String observacion;

    public FichaMedica() {
    }

    public FichaMedica(Long id) {
        this.id = id;
    }

    public FichaMedica(String observacion) {
        this.observacion = observacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
