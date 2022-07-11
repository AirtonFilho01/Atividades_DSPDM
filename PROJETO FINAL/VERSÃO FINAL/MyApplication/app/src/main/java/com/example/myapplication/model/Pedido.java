package com.example.myapplication.model;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Pedido implements Serializable {

    private int id;
    private int posicao;
    private Double preco;
    private String pedido;
    private boolean entregue;
    private String reclamacao;
    private double lat;
    private double log;
    private byte[] fotoReclamacao;

    public Pedido() {
    }

    public Pedido(int id, int posicao, Double preco, String pedido, boolean entregue, String reclamacao, double lat,
                  double log) {
        super();
        this.id = id;
        this.posicao = posicao;
        this.preco = preco;
        this.pedido = pedido;
        this.entregue = entregue;
        this.reclamacao = reclamacao;
        this.lat = lat;
        this.log = log;
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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLog() {
        return log;
    }

    public void setLog(double log) {
        this.log = log;
    }

    public byte[] getFotoReclamacao() {
        return fotoReclamacao;
    }

    public void setFotoReclamacao(byte[] fotoReclamacao) {
        this.fotoReclamacao = fotoReclamacao;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", posicao=" + posicao + ", preco=" + preco + ", pedido=" + pedido + ", entregue="
                + entregue + ", reclamacao=" + reclamacao + ", lat=" + lat + ", log=" + log + "]";
    }



}
