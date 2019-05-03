package br.com.loja_online.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/{id_carrinho_de_compras}")
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> listarTodosOsProdutosDoCarrinho(@PathVariable Long id_carrinho_de_compras) {
		if (isClienteLogado()) {
			 CarrinhoDeCompra carrinhoDoClienteLogado = repositorioCarrinhosDeCompras
					 .findById(id_carrinho_de_compras).get();
			return carrinhoDoClienteLogado.getListaDeProdutosDoCarrinho();
		}
		return null;
	}

	@PostMapping("/{id_carrinho}/{id_produto}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Produto> adicionarProdutoAoCarrinhoDeCompras(@PathVariable Long id_carrinho, @PathVariable Long id_produto) {
		if (isClienteLogado()) {
			 CarrinhoDeCompra carrinhoDoClienteLogado = repositorioCarrinhosDeCompras
					 .getOne(id_carrinho);
			 setListaDeProdutos( carrinhoDoClienteLogado.getListaDeProdutosDoCarrinho() );
			 getListaDeProdutos().add( repositorioDeProdutosDoEstoque.getOne(id_produto) );
			 
			 VendasRealizadaController vendasRealizadaController = new VendasRealizadaController();
			 vendasRealizadaController.setCarrinhoVendas(getCarrinhoDeCompra());
			 
			 repositorioCarrinhosDeCompras.save( getCarrinhoDeCompra() );
			 
			 return getListaDeProdutos();
		}
		return null;
	}

	@DeleteMapping("/{id_carrinho}/{id_produto}")
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> removerProdutosDoCarrinhoDeCompra(@PathVariable Long id_carrinho, @PathVariable Long id_produto) {
		if (isClienteLogado()) {
			 CarrinhoDeCompra carrinhoDoClienteLogado = repositorioCarrinhosDeCompras
					 .getOne(id_carrinho);
			 setListaDeProdutos( carrinhoDoClienteLogado.getListaDeProdutosDoCarrinho() );
			 getListaDeProdutos().remove( repositorioDeProdutosDoEstoque.getOne(id_produto) );
			 
			 VendasRealizadaController vendasRealizadaController = new VendasRealizadaController();
			 vendasRealizadaController.setCarrinhoVendas(getCarrinhoDeCompra());
			 
			 repositorioCarrinhosDeCompras.save( getCarrinhoDeCompra() );
			 return getListaDeProdutos();
		}
		return null;
	}
}
