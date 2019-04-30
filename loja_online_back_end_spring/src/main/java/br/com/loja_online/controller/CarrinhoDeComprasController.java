package br.com.loja_online.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.CarrinhoDeCompra;
import br.com.loja_online.model.Produto;
import br.com.loja_online.repository.CarrinhoDeComprasRepository;
import br.com.loja_online.repository.ProdutoRepository;

/**
 * @author CLAUDIO
 *
 */
@RestController
@RequestMapping("/api/carrinho_de_compras")
public class CarrinhoDeComprasController {

	@Autowired
	private CarrinhoDeComprasRepository repositorioCarrinhosDeCompras;

	@Autowired
	private ProdutoRepository repositorioDeProdutosDoEstoque;

	private CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompra();
	private CarrinhoDeCompra carrinho = new CarrinhoDeCompra();

	private List<Produto> listaDeProdutos = new ArrayList<>();

	private boolean clienteLogado = true;

	public CarrinhoDeComprasController() {
	}

	public boolean isClienteLogado() {
		return clienteLogado;
	}

	public void setClienteLogado(boolean clienteLogado) {
		this.clienteLogado = clienteLogado;
	}

	public CarrinhoDeCompra getCarrinhoDeCompra() {
		return carrinhoDeCompra;
	}

	public void setCarrinhoDeCompra(CarrinhoDeCompra carrinhoDeCompra) {
		this.carrinhoDeCompra = carrinhoDeCompra;
	}

	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

	public CarrinhoDeCompra getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoDeCompra carrinho) {
		this.carrinho = carrinho;
	}

	@GetMapping("/{id_carrinho_de_compras}")
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> listarTodosOsProdutosDoCarrinho(@PathVariable Long id_carrinho_de_compras) {
		if (clienteLogado) {
			 CarrinhoDeCompra carrinhoDoClienteLogado = repositorioCarrinhosDeCompras
					 .findById(id_carrinho_de_compras).get();
			return carrinhoDoClienteLogado.getListaDeProdutosDoCarrinho();
		}
		return null;
	}

	@PutMapping("/{id_carrinho}/{id_produto}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Produto> adicionarProdutoAoCarrinhoDeCompras(
				@PathVariable Long id_carrinho, 
				@PathVariable Long id_produto
			) {
		if (clienteLogado) {
			
			Produto produtoAdicionado = repositorioDeProdutosDoEstoque.getOne(id_produto);
			
			int quantidadeInicial = 1;

			carrinhoDeCompra = repositorioCarrinhosDeCompras.getOne(id_carrinho);
			Produto produto = repositorioDeProdutosDoEstoque.getOne(id_produto);
			
			if ( !carrinhoDeCompra.getListaDeProdutosDoCarrinho().contains(produtoAdicionado) ) {
				produto.setQuantidadeProduto(String.valueOf(quantidadeInicial));
				carrinhoDeCompra.getListaDeProdutosDoCarrinho().add(produto);
				carrinho.getListaDeProdutosDoCarrinho().add(produto);
				repositorioCarrinhosDeCompras.save(carrinhoDeCompra);
				Produto p = repositorioDeProdutosDoEstoque.getOne(id_produto);
				String quantidade = p.getQuantidadeProduto();
				int novaQuantidade = Integer.parseInt(quantidade);
				p.setQuantidadeProduto(String.valueOf(novaQuantidade - 1));
				repositorioDeProdutosDoEstoque.save(p);
				return carrinhoDeCompra.getListaDeProdutosDoCarrinho();
			} else {
				produto.setQuantidadeProduto(String.valueOf(quantidadeInicial + 1));
				carrinhoDeCompra.getListaDeProdutosDoCarrinho().add(produto);
				carrinho.getListaDeProdutosDoCarrinho().add(produto);
				repositorioCarrinhosDeCompras.save(carrinhoDeCompra);
				Produto p = repositorioDeProdutosDoEstoque.getOne(id_produto);
				String quantidade = p.getQuantidadeProduto();
				int novaQuantidade = Integer.parseInt(quantidade);
				p.setQuantidadeProduto(String.valueOf(novaQuantidade - 1));
				repositorioDeProdutosDoEstoque.save(p);
				return carrinhoDeCompra.getListaDeProdutosDoCarrinho();
			}


		}
		return null;
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> removerProdutosDoCarrinhoDeCompra(@RequestBody Map<String, String> produtoJson) {
		if (clienteLogado) {
			carrinhoDeCompra = repositorioCarrinhosDeCompras.getOne( Long.parseLong(produtoJson.get("id_carrinho") ));
			Produto produto = repositorioDeProdutosDoEstoque.getOne( Long.parseLong(produtoJson.get("id_produto") ));
			carrinhoDeCompra.getListaDeProdutosDoCarrinho().remove(produto);
			carrinho.getListaDeProdutosDoCarrinho().remove(produto);
			repositorioCarrinhosDeCompras.save(carrinhoDeCompra);
			Produto p = repositorioDeProdutosDoEstoque.getOne( Long.parseLong(produtoJson.get("id_produto") ));
			String quantidade = p.getQuantidadeProduto();
			int novaQuantidade = Integer.parseInt(quantidade);
			p.setQuantidadeProduto( String.valueOf(novaQuantidade + 1) );
			repositorioDeProdutosDoEstoque.save(p);
			return carrinhoDeCompra.getListaDeProdutosDoCarrinho();
		}
		return null;
	}
}
