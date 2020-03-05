package br.com.ufopaoriximina.projcadfish.model;

import android.graphics.Bitmap;

public class Usuario {

    private String name;
    private String email;
    private String senha;
    private int anosxp;
    private long cpf;
    private long telfone;
    private String estado;
    private String cidade;
    private Bitmap foto;

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAnosxp() {
        return anosxp;
    }

    public void setAnosxp(int anosxp) {
        this.anosxp = anosxp;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getTelfone() {
        return telfone;
    }

    public void setTelfone(long telfone) {
        this.telfone = telfone;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
