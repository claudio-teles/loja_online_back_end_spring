package br.com.loja_online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.Liquidacao;
import br.com.loja_online.repository.LiquidacaoRepository;


/**
 * @author CLAUDIO
 *
 */
@CrossOrigin
@RestController
@RequestMapping("api/liquidacoes")
public class LiquidacaoController {
	
	@Autowired
	private LiquidacaoRepository repositorioDeLiquidacao;
	
	/**
	 * 
	 */
	public LiquidacaoController() {}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Liquidacao> listarProdutosEmLiquidacao() {
		return repositorioDeLiquidacao.findAll();
	}

}