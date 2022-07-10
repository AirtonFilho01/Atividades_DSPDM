package com.model;



import java.io.Serializable;
import java.util.ArrayList;

public class FabricaQuentinha implements Serializable {

    private Entregador entregador;
    private ArrayList <Pedido> pedidos = new ArrayList<Pedido>();
    private String pratoDoDia = "Arroz + Feijão + Crane: POR 10.00";
    private Double preco = 10.00;
    private int contPedidos = 0;

    public FabricaQuentinha() {
    }

    public FabricaQuentinha(Entregador entregador, ArrayList<Pedido> pedidos, String pratoDoDia, Double preco, int contPedidos) {
        this.entregador = entregador;
        this.pedidos = pedidos;
        this.pratoDoDia = pratoDoDia;
        this.preco = preco;
        this.contPedidos = contPedidos;
    }

    public void popular(){
        entregador = new Entregador();
        Pedido p = new Pedido(0, 0, 10.0, "Arroz de Leite", false);
        pedidos.add(p);
        p = new Pedido(1, 1, 10.0, "Arroz", false);
        pedidos.add(p);
        p = new Pedido(2, 2, 10.0, "Leite", false);
        pedidos.add(p);

        contPedidos = 3;
    }


    public Pedido add(Pedido p){
        contPedidos++;
        p.setId(contPedidos);
        p.setPosicao(contPedidos);
        p.setPedido(pratoDoDia);
        p.setPreco(preco);
        p.setEntregue(false);

        pedidos.add(p);

        return p;
    }

    public void remover(Pedido p){
        for (int i = 0; i < pedidos.size(); i++) {
            if(pedidos.get(i).getId() == p.getId())
                pedidos.remove(i);
        }

    }

    public void editar(Pedido p){

        for (int i = 0; i < pedidos.size(); i++) {
            if(pedidos.get(i).getId() == p.getId()){
                pedidos.set(i,p);
                break;
            }
        }
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getPratoDoDia() {
        return pratoDoDia;
    }

    public void setPratoDoDia(String pratoDoDia) {
        this.pratoDoDia = pratoDoDia;
    }

    @Override
    public String toString() {
        return "FabricaQuentinha{" +
                "entregador=" + entregador +
                ", pedidos=" + pedidos +
                ", pratoDoDia='" + pratoDoDia + '\'' +
                ", preco=" + preco +
                ", contPedidos=" + contPedidos +
                '}';
    }
}
