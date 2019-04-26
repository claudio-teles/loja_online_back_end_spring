package br.com.loja_online.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	private List<Produto> listaDeProdutos = new ArrayList<>();
	
	private boolean clienteLogado = false;

	public CarrinhoDeComprasController() {}
	
	
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


	@GetMapping("/{id_carrinho_de_compras}")
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> listarTodosOsProdutosDoCarrinho(@PathVariable Long id_carrinho_de_compras) {
		if (isClienteLogado() == true) {
			return repositorioCarrinhosDeCompras.findByIdCarrinho(id_carrinho_de_compras);
		}
		return null;
	}
	


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<Produto> adicionarProdutoAoCarrinhoDeCompras(@RequestBody Map<String, String> produtoJson) {
		
		if (isClienteLogado() == true) {
			
			List<Produto> repositorioDeProdutos = new ArrayList<>();
			repositorioDeProdutos = repositorioDeProdutosDoEstoque.findAll();
			
			for (Produto produto : repositorioDeProdutos) {

				if (produto.getIdProduto() == Integer.parseInt( produtoJson.get("id_produto") )) {
					listaDeProdutos = carrinhoDeCompra.getListaDeProdutosDoCarrinho();
					produto.setQuantidadeProduto(1);
					listaDeProdutos.add(produto);

					if (produto.getQuantidadeProduto() > 0) {
						Produto p = repositorioDeProdutosDoEstoque.getOne( Long.parseLong( produtoJson.get("id_produto") ) );
						p.setQuantidadeProduto(p.getQuantidadeProduto() - 1);
						repositorioDeProdutosDoEstoque.saveAndFlush(p);
						repositorioCarrinhosDeCompras.save(carrinhoDeCompra);
					}
				}

			} 
		}
		return null;
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public List<Produto> removerProdutosDoCarrinhoDeCompra(@PathVariable Map<String, String> produtoJson) {
		
		if (isClienteLogado() == true) {
			
			List<Produto> repositorioDeProdutos = new ArrayList<>();
			repositorioDeProdutos = repositorioDeProdutosDoEstoque.findAll();
			
			for (Produto produto : repositorioDeProdutos) {

				if (produto.getIdProduto() == Integer.parseInt( produtoJson.get("id_produto") )) {
					listaDeProdutos = carrinhoDeCompra.getListaDeProdutosDoCarrinho();
					listaDeProdutos.remove(produto);

					if (produto.getQuantidadeProduto() > 0) {
						Produto p = repositorioDeProdutosDoEstoque.getOne( Long.parseLong( produtoJson.get("id_produto") ) );
						p.setQuantidadeProduto(p.getQuantidadeProduto() + 1);
						repositorioDeProdutosDoEstoque.saveAndFlush(p);
						repositorioCarrinhosDeCompras.save(carrinhoDeCompra);
					}
				}

			} 
		}
		return null;
	}
}
