/**
 * 
 */
package br.com.loja_online.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.ClientesLogado;
import br.com.loja_online.model.Loja;
import br.com.loja_online.repository.ClienteLogadoRepository;
import br.com.loja_online.repository.LojaRepository;

/**
 * @author CLAUDIO
 *
 */
@RestController
@RequestMapping("api/lojas")
public class LojaController {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@Autowired
	private ClienteLogadoRepository repositorioDeClienteLogado;
	
	private String nomeDoCliente = "";

	/**
	 * 
	 */
	public LojaController() {}
	
	public String getNomeDoCliente() {
		return nomeDoCliente;
	}

	public void setNomeDoCliente(String nomeDoCliente) {
		this.nomeDoCliente = nomeDoCliente;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Optional<Loja> exibirEstoqueDaLoja() {
		return lojaRepository.findById( (long)1 );
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public String fazerLogOff() {
		ClientesLogado logado = new ClientesLogado();
		IndexController paginaInicial = new IndexController();
		
		logado.setStatusClienteLogado(false);
		paginaInicial.setNomeDoCliente("Faça o login para poder fazer compras!");
		repositorioDeClienteLogado.save(logado);
		
		return "Você está deslogado!";
	}

}
