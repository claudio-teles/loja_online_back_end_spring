package br.com.loja_online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.Produto;
import br.com.loja_online.repository.ProdutoRepository;


/**
 * @author CLAUDIO
 *
 */
@RestController
@RequestMapping("api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository reposiorioDeProdutos;

	/**
	 * 
	 */
	public ProdutoController() {}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> listarProdutos() {
		return reposiorioDeProdutos.findAll();
	}

}
