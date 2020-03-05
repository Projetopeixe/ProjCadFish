package br.com.ufopaoriximina.projcadfish.model;

import android.graphics.Bitmap;

public class Peixe {

    private String especie;
    private Double peso;
    private Double tamanho;
    private String marca_tag;
    private String location;
    private Bitmap fotoPeixe;

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public String getMarca_tag() {
        return marca_tag;
    }

    public void setMarca_tag(String marca_tag) {
        this.marca_tag = marca_tag;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Bitmap getFotoPeixe() {
        return fotoPeixe;
    }

    public void setFotoPeixe(Bitmap fotoPeixe) {
        this.fotoPeixe = fotoPeixe;
    }
}
