package br.com.ufopaoriximina.projcadfish.model;

import android.graphics.Bitmap;

public class Usuario {

    private int id;
    private String name;
    private String email;
    private String senha;
    private int anosxp;
    private String cpf;
    private String telefone;
    private String estado;
    private String cidade;
    private byte[] foto;
    private int tipo;
    private int IdInfoGeral;

    public int getIdInfoGeral() {
        return IdInfoGeral;
    }

    public void setIdInfoGeral(int idInfoGeral) {
        IdInfoGeral = idInfoGeral;
    }

    public Usuario(String email, String senha, byte[] foto, int tipo, int IdInfo) {
        this.email = email;
        this.senha = senha;
        this.foto = foto;
        this.tipo = tipo;
        this.IdInfoGeral = IdInfo;
    }

    public Usuario(String nome, int anosxp, String cpf, String telefone, String cidade, String estado){
        this.name = nome;
        this.anosxp = anosxp;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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