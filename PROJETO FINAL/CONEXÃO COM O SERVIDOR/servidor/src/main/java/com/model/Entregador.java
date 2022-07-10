package com.model;


import java.io.Serializable;

public class Entregador implements Serializable {

    //posição da entrega que esta realizado

    private int posicao;

    public Entregador() {
    }

    public Entregador(int posicao) {
        this.posicao = posicao;
    }

    public int getPosicao() {
        return posicao;
    }

    @Override
    public String toString() {
        return "Entregador{" +
                "posicao=" + posicao +
                '}';
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}
