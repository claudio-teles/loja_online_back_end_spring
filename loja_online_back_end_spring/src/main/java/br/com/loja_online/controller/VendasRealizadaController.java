package br.com.loja_online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.CarrinhoDeCompra;
import br.com.loja_online.model.ClientesCadastrado;
import br.com.loja_online.model.Produto;
import br.com.loja_online.model.VendasRealizada;
import br.com.loja_online.repository.VendasRealizadaRepository;


/**
 * @author CLAUDIO
 *
 */
@RestController
@RequestMapping("api/vendas_realizadas")
public class VendasRealizadaController {
	
	@Autowired
	private VendasRealizadaRepository reposioritoDeVendas;

	/**
	 * 
	 */
	public VendasRealizadaController() {}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<Produto> finalizarCompraDeProdutos() {
		
		CarrinhoDeComprasController comprasController = new CarrinhoDeComprasController();
		CarrinhoDeCompra carrinhoDeCompra = comprasController.getCarrinhoDeCompra();
		ClientesCadastrado cliente = carrinhoDeCompra.getClientesCadastrado();
		List<Produto> listaDeProdutosDoCarrinho = carrinhoDeCompra.getListaDeProdutosDoCarrinho();
		
		VendasRealizada vendaFinalizada = new VendasRealizada();
		vendaFinalizada.setClientesCadastrado(cliente);
		vendaFinalizada.setListaDeProdutosComprados(listaDeProdutosDoCarrinho);
		
		reposioritoDeVendas.save(vendaFinalizada);
		
		return listaDeProdutosDoCarrinho;
	}

}
