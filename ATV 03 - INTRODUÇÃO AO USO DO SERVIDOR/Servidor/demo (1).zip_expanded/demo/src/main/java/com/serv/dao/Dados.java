package com.serv.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.serv.repository.Cliente;

public class Dados {
	


	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public Dados(){
	}
	
	public void popular() {
		clientes.add(new Cliente(0, "Antonio", "Toim"));
		clientes.add(new Cliente(1, "Airton",  "ton"));
		clientes.add(new Cliente(2, "Ferreira", "Fé"));
		clientes.add(new Cliente(3, "Oliveira", "Veira"));
	}
	
	public void add(int id, String nome, String apelido) {
		clientes.add(new Cliente(id,nome, apelido));
	}
	
	public void delete(int id) {
		for (Iterator iterator = clientes.iterator(); iterator.hasNext();) {
			Cliente cliente = (Cliente) iterator.next();
			if (cliente.getId() == id) {
				clientes.remove(iterator);
			}
		}
	}
	
	public void editar(int id, String nome, String apelido) {
		Cliente c;
		for (int i = 0; i < clientes.size(); i++) {
			c = clientes.get(i);
			if (c.getId() == id) {
				c.setNome(nome);
				c.setApelido(apelido);
				clientes.set(i, c);
				break;
			}
		}
		
	}
	
	@Override
	public String toString() {
		return "Dados [clientes=" + clientes + "]";
	}

	public String listar() {
		return clientes.toString();
	}

	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
}

	
