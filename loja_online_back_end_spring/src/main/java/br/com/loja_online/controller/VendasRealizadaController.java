package br.com.loja_online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.CarrinhoDeCompra;
import br.com.loja_online.model.ClientesCadastrado;
import br.com.loja_online.model.Produto;
import br.com.loja_online.model.VendasRealizada;
import br.com.loja_online.repository.CarrinhoDeComprasRepository;
import br.com.loja_online.repository.ClienteCadastradoRepository;
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
	
	@Autowired
	private CarrinhoDeComprasRepository carrinhoDeComprasRepository;
	
	@Autowired
	private ClienteCadastradoRepository clienteCadastradoRepository;
	
	/**
	 * 
	 */
	public VendasRealizadaController() {}
	
	@PostMapping("/{id_carrinho}/{id_clienteCadastrado}")
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> finalizarCompraDeProdutos(@PathVariable Long id_carrinho, @PathVariable Long id_clienteCadastrado) {
		
		ClientesCadastrado clientesCadastrado = clienteCadastradoRepository.getOne(id_clienteCadastrado);
		List<Produto> listaDeProdutosDoCarrinho = carrinhoDeComprasRepository.getOne(id_carrinho).getListaDeProdutosDoCarrinho();
		CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompra(clientesCadastrado, listaDeProdutosDoCarrinho);
		
		VendasRealizada vendaFinalizada = new VendasRealizada();
		vendaFinalizada.setClienteCadastrado(clientesCadastrado);
		vendaFinalizada.setListaDeProdutosComprados(carrinhoDeCompra.getListaDeProdutosDoCarrinho());
		reposioritoDeVendas.save(vendaFinalizada);
		
		return listaDeProdutosDoCarrinho;
	}

}
