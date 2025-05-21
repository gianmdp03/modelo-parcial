package com.modelo.parcial.modelo_parcial.exception;

import java.time.LocalDate;

public class ErrorResponse {
    private int codigo;
    private String error;
    private String mensaje;
    private LocalDate timestamp;

    public ErrorResponse(int codigo, String error, String mensaje)
    {
        this.codigo = codigo;
        this.error = error;
        this.mensaje = mensaje;
        this.timestamp = LocalDate.now();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
}
