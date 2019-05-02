package br.com.loja_online.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	private boolean clienteLogado = false;

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

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<Produto> adicionarProdutoAoCarrinhoDeCompras(
			@RequestBody Map<String, Long> produtoJson
			) {
		if (clienteLogado == true) {
			carrinhoDeCompra = repositorioCarrinhosDeCompras.getOne( produtoJson.get("id_carrinho") );
			List<Produto> produtos = carrinhoDeCompra.getListaDeProdutosDoCarrinho();
			produtos.add( repositorioDeProdutosDoEstoque.getOne( produtoJson.get("id_produto") ) );
			repositorioCarrinhosDeCompras.save(carrinhoDeCompra);
			return produtos;
		}
		return null;
	}

	@RequestMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> removerProdutosDoCarrinhoDeCompra(@RequestBody Map<String, Long> produtoJson) {
		if (clienteLogado) {
			Optional<CarrinhoDeCompra> optCarrrinho = repositorioCarrinhosDeCompras
					.findById( produtoJson.get("id_carrinho") );
			CarrinhoDeCompra carrinhoDeCompra = optCarrrinho.get();
			List<Produto> produtos = carrinhoDeCompra.getListaDeProdutosDoCarrinho();
			produtos.remove( repositorioDeProdutosDoEstoque.getOne( produtoJson.get("id_produto") ) );
			repositorioCarrinhosDeCompras.save(carrinhoDeCompra);
			return produtos;
		}
		return null;
	}
}
