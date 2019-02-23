package com.pepe.malpica.models;

import java.io.Serializable;

public class Persona implements Serializable {

    private String curp;
    private String nombres;
    private String subTipo;
    private String ciudad;
    private String primerApellido;
    private String sexo;
    private String segundoApellido;
    private String seccion;
    private String estado;
    private String municipio;
    private String edad;
    private String claveElector;
    private String calle;
    private String localidad;

    public Persona() {
    }

    public Persona(String curp, String nombres, String subTipo, String ciudad, String primerApellido, String sexo, String segundoApellido, String seccion, String estado, String municipio, String edad, String claveElector, String calle, String localidad) {
        this.curp = curp;
        this.nombres = nombres;
        this.subTipo = subTipo;
        this.ciudad = ciudad;
        this.primerApellido = primerApellido;
        this.sexo = sexo;
        this.segundoApellido = segundoApellido;
        this.seccion = seccion;
        this.estado = estado;
        this.municipio = municipio;
        this.edad = edad;
        this.claveElector = claveElector;
        this.calle = calle;
        this.localidad = localidad;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSubTipo() {
        return subTipo;
    }

    public void setSubTipo(String subTipo) {
        this.subTipo = subTipo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getClaveElector() {
        return claveElector;
    }

    public void setClaveElector(String claveElector) {
        this.claveElector = claveElector;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
