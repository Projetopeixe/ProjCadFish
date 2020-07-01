package br.com.ufopaoriximina.projcadfish.model;

import android.graphics.Bitmap;

public class Grupo {

    private int id;
    private String nome;
    private byte[] foto;

    public Grupo(String nome, byte[] foto, String data) {
        this.nome = nome;
        this.foto = foto;
        this.data = data;
    }



    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}