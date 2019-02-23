package com.pepe.malpica.models;

import java.io.Serializable;

public class ResponseModel implements Serializable {

    private String estatus;
    private String mensaje;
    private String codigoValidacion;
    private Persona persona;

    public ResponseModel() {
    }

    public ResponseModel(String estatus, String mensaje, String codigoValidacion, Persona persona) {
        this.estatus = estatus;
        this.mensaje = mensaje;
        this.codigoValidacion = codigoValidacion;
        this.persona = persona;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodigoValidacion() {
        return codigoValidacion;
    }

    public void setCodigoValidacion(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
