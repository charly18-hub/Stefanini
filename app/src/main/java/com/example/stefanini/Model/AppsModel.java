package com.example.stefanini.Model;

public class AppsModel {

    String appNombre;
    String desarrollador;
    int calificacion;
    String url_image;


    String url_encabezado;
    int precio;

    public AppsModel(String appNombre, String desarrollador, int calificacion, String url_image, String url_encabezado, int precio) {
        this.appNombre = appNombre;
        this.desarrollador = desarrollador;
        this.calificacion = calificacion;
        this.url_image = url_image;
        this.url_encabezado = url_encabezado;
        this.precio = precio;
    }

    public String getAppNombre() {
        return appNombre;
    }

    public void setAppNombre(String appNombre) {
        this.appNombre = appNombre;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getUrl_encabezado() {
        return url_encabezado;
    }

    public void setUrl_encabezado(String url_encabezado) {
        this.url_encabezado = url_encabezado;
    }
}
