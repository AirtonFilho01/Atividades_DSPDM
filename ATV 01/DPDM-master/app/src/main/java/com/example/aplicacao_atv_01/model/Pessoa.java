package com.example.aplicacao_atv_01.model;

import java.security.PrivateKey;

public class Pessoa {

    public Pessoa() {
    }


    private String nome;
    private int id;
    private boolean vacinado;
    private  String cidade;
    private  String dose;

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", vacinado=" + vacinado +
                ", cidade='" + cidade + '\'' +
                ", dose='" + dose + '\'' +
                '}';
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public boolean isVacinado() {
        return vacinado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }
}
