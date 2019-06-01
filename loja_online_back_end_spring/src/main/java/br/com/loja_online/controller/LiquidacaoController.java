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

import br.com.loja_online.model.Liquidacao;
import br.com.loja_online.model.Produto;
import br.com.loja_online.repository.LiquidacaoRepository;


/**
 * @author CLAUDIO
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/liquidacoes")
public class LiquidacaoController {
	
	@Autowired
	private LiquidacaoRepository repositorioDeLiquidacao;
	
	/**
	 * 
	 */
	public LiquidacaoController() {}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> listarProdutosEmLiquidacao() {
		long quantidadeDeProdutos = repositorioDeLiquidacao.count();
		List<Liquidacao> listaDeItens =  repositorioDeLiquidacao.findAll().subList(0, (int) quantidadeDeProdutos);
		List<Produto> produtos = new ArrayList<>();
		
		for (int i = 0; i < quantidadeDeProdutos; i++) {
			Liquidacao item = listaDeItens.get(i);
			 produtos.addAll(item.getListaDeProdutosEmLiquidacao());
		}
		return produtos;
	}

}