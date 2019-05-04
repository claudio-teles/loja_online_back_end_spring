package br.com.loja_online.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.Produto;
import br.com.loja_online.repository.ProdutoRepository;


/**
 * @author CLAUDIO
 *
 */
@CrossOrigin
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
	
	@GetMapping("/{id_produto}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Produto> exibirUmProduto(@PathVariable Long id_produto) {
		return reposiorioDeProdutos.findById(id_produto);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Produto alterarComentarioDoProduto(@RequestBody Map<String, String> produtoAvalicaoJson) {
		
		Produto produto = reposiorioDeProdutos.findById( Long.parseLong(produtoAvalicaoJson.get("id_produto")) ).get();
		String avaliacao = produto.getAvaliacao();
		avaliacao = avaliacao + "\n";
		avaliacao += produtoAvalicaoJson.get("nova_avaliação");
		
		produto.setAvaliacao(avaliacao);
		System.out.println("Nova avaliação do produto: " + produto.getAvaliacao()+".");
		
		return reposiorioDeProdutos.save(produto);
		
	}
	
	@PutMapping("/{id_produto}/{curtir}")
	@ResponseStatus(HttpStatus.OK)
	public Produto alterarCurtirNoProduto(@PathVariable Long id_produto, @PathVariable String curtir) {
		
		Produto produto = reposiorioDeProdutos.findById(id_produto ).get();
		
		if ( curtir == "Sim" ) {
			String valorDeCurtidas = produto.getCurtiu();
			int novoValorDeCurtidas = Integer.parseInt(valorDeCurtidas) + 1;
			produto.setCurtiu( String.valueOf(novoValorDeCurtidas) );
			return reposiorioDeProdutos.save(produto);
		} else {
			String valorDeNaoCurtidas = produto.getNaoCurtiu();
			int novoValorDeNaoCurtidas = Integer.parseInt(valorDeNaoCurtidas) - 1;
			produto.setNaoCurtiu( String.valueOf(novoValorDeNaoCurtidas) );
			return reposiorioDeProdutos.save(produto);
		}
		
	}

}
