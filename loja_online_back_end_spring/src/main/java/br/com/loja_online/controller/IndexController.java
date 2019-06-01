package br.com.loja_online.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author CLAUDIO
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/")
public class IndexController {
	
	private String mensagemDeBoasVindas = "Bem vindo a Loja Online feito com Angular e Spring, "
			+ "os produtos são fictícios.";
	
	private String nomeDoCliente = "";

	/**
	 * 
	 */
	public IndexController() {}
	public String getMensagemDeBoasVindas() {
		return mensagemDeBoasVindas;
	}

	public void setMensagemDeBoasVindas(String mensagemDeBoasVindas) {
		this.mensagemDeBoasVindas = mensagemDeBoasVindas;
	}

	public String getNomeDoCliente() {
		return nomeDoCliente;
	}

	public void setNomeDoCliente(String nomeDoCliente) {
		this.nomeDoCliente = nomeDoCliente;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public String index() {
		return getMensagemDeBoasVindas();
	}
	
}
