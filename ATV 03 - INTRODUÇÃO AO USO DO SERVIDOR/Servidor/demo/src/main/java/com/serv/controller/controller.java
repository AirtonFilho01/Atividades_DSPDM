package com.serv.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.serv.dao.Dados;
import com.serv.repository.Cliente;

@RestController
@Controller
@Transactional
@RequestMapping("/")
public class controller {
	
private Dados dados = new Dados();

public boolean populado = false;

Gson gson = new Gson();


private Cliente cliente;

/*@GetMapping
public ResponseEntity listar() {
	System.err.println("LISTAR RETORNADO!!");
	return new ResponseEntity(dados.listar(),HttpStatus.OK);
}
*/

@RequestMapping("listar")
public String listar() {
	
	System.err.println("LISTAR RETORNADO!!");
	if(populado)
		return gson.toJson(dados);
	
	dados.popular();
	populado = true;
	return gson.toJson(dados);
}


@RequestMapping(value = "receber", method = RequestMethod.POST)
public int receber(@RequestBody Dados d) {
	System.err.println("DADOS RECEBIDOS: "+ d.toString());
	
	this.dados = d;
	
	if (d != null)
		return 1;
	else
		return 0;
}


}
