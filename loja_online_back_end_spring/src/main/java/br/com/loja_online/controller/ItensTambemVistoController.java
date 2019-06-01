package br.com.loja_online.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.ItensTambemVisto;
import br.com.loja_online.model.Produto;
import br.com.loja_online.repository.ItensTambemVistoRepository;



/**
 * @author CLAUDIO
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/itens_tambem_vistos")
public class ItensTambemVistoController {
	
	@Autowired
	private ItensTambemVistoRepository repositorioItensVistos;
	
	/**
	 * 
	 */
	public ItensTambemVistoController() {}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> listarProdutosTambemVistos() {
		long quantidadeDeProdutos = repositorioItensVistos.count();
		List<ItensTambemVisto> listaDeItens =  repositorioItensVistos.findAll().subList(0, (int) quantidadeDeProdutos);
		List<Produto> produtos = new ArrayList<>();
		
		for (int i = 0; i < quantidadeDeProdutos; i++) {
			ItensTambemVisto item = listaDeItens.get(i);
			 produtos.addAll(item.getlistaDeItensTambemVistos());
		}
		return produtos;
	}

}
