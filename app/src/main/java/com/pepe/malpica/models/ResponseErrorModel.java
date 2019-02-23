package com.pepe.malpica.models;

import java.io.Serializable;

public class ResponseErrorModel implements Serializable {
    private String estatus;
    private String mensaje;
    private String codigoValidacion;

    public ResponseErrorModel() {
    }

    public ResponseErrorModel(String estatus, String mensaje, String codigoValidacion) {
        this.estatus = estatus;
        this.mensaje = mensaje;
        this.codigoValidacion = codigoValidacion;
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
}
