package com.controller;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.model.Entregador;
import com.model.FabricaQuentinha;
import com.model.Pedido;

@RestController
@Controller
@Transactional
@RequestMapping("/")
public class controller {

	Entregador entregador;
	Pedido pedido;
	FabricaQuentinha fabricaQuentinha = new FabricaQuentinha();
	String status = "0";
	
	Gson gson = new Gson();
	public boolean populado = false;


	
	@RequestMapping("listar")
	public String listar() {
		System.err.println("LISTAR RETORNADO!!");
		if(populado)
			return gson.toJson(fabricaQuentinha);
		
		fabricaQuentinha.popular();
		populado = true;
		return gson.toJson(fabricaQuentinha);
	}
	
	@RequestMapping(value = "receber", method = RequestMethod.POST)
	public int receber(@RequestBody FabricaQuentinha f) {
		System.err.println("DADOS RECEBIDOS: "+ f.toString());
		
		this.fabricaQuentinha = f;
		
		if (f != null)
			return 1;
		else
			return 0;
	}
	
	@RequestMapping("status")
	public String status() {
		System.err.println("ENVIANDO STATUS");
		
		return gson.toJson(status);
	}
	
}
