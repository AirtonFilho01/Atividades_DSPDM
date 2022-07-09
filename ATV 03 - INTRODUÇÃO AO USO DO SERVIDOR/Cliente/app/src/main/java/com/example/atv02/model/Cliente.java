package com.example.atv02.model;

import java.io.Serializable;

public class Cliente implements Serializable {


        private int id;
        private String nome;
        private String apelido;

        public Cliente() {
        }

         public Cliente(int id, String nome, String apelido) {
            this.id = id;
            this.nome = nome;
            this.apelido = apelido;
        }

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

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                '}';
    }


}
