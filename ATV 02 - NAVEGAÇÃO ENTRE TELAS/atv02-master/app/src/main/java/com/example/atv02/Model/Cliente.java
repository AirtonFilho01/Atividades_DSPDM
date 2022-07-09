package com.example.atv02.Model;

import java.io.Serializable;

public class Cliente implements Serializable {

    private int id;
    private String Nome;
    private String Apelido;

    public Cliente() {
    }

    public Cliente(int id, String nome, String apelido) {
        this.id = id;
        Nome = nome;
        Apelido = apelido;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return Nome;
    }

    public String getApelido() {
        return Apelido;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setApelido(String apelido) {
        Apelido = apelido;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", Nome='" + Nome + '\'' +
                ", Apelido='" + Apelido + '\'' +
                "\n";
    }
}
