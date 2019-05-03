package br.com.loja_online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.CarrinhoDeCompra;
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
	


	
	private CarrinhoDeCompra carrinhoVendas = new CarrinhoDeCompra();
	
	/**
	 * 
	 */
	public VendasRealizadaController() {}
	
	public CarrinhoDeCompra getCarrinhoVendas() {
		return carrinhoVendas;
	}

	public void setCarrinhoVendas(CarrinhoDeCompra carrinhoVendas) {
		this.carrinhoVendas = carrinhoVendas;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> finalizarCompraDeProdutos() {
		ClientesCadastradosController ccc = new ClientesCadastradosController(); 
		VendasRealizada vendasRealizada = new VendasRealizada();
		vendasRealizada.setPrimeiroNome( ccc.getPrimeiroNome() );
		vendasRealizada.setSobreNome( ccc.getSobreNome() );
		vendasRealizada.setNomeDeUsuario( ccc.getNomeDeUsuario() );
		for (Produto p: getCarrinhoVendas().getListaDeProdutosDoCarrinho()) {
			vendasRealizada.getListaDeProdutosComprados().add(p);
		}
		reposioritoDeVendas.save(vendasRealizada);
		return getCarrinhoVendas().getListaDeProdutosDoCarrinho();
	}

}
