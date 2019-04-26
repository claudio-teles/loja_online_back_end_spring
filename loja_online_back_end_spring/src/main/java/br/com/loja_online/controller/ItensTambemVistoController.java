package br.com.loja_online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.ItensTambemVisto;
import br.com.loja_online.repository.ItensTambemVistoRepository;



/**
 * @author CLAUDIO
 *
 */
@RestController
@RequestMapping("api/itens_tambem_vistos")
public class ItensTambemVistoController {
	
	@Autowired
	private ItensTambemVistoRepository repositorioItensVistos;
	
	/**
	 * 
	 */
	public ItensTambemVistoController() {}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ItensTambemVisto> listarProdutosTambemVistos() {
		return repositorioItensVistos.findAll();
	}

}
