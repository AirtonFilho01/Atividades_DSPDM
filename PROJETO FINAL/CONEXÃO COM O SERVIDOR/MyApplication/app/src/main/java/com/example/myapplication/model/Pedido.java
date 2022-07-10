package com.example.myapplication.model;

import java.io.Serializable;

public class Pedido implements Serializable {

    private int id;
    private int posicao;
    private Double preco;
    private String pedido;
    private boolean entregue;
    private String reclamacao;

    public Pedido() {
    }

    public Pedido(int id, int posicao, Double preco, String pedido, boolean entregue) {
        this.id = id;
        this.posicao = posicao;
        this.preco = preco;
        this.pedido = pedido;
        this.entregue = entregue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        this.reclamacao = reclamacao;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", posicao=" + posicao +
                ", preco=" + preco +
                ", pedido='" + pedido + '\'' +
                '}';
    }
}
