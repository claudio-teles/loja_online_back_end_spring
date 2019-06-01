package br.com.loja_online.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.CarrinhoDeCompra;
import br.com.loja_online.model.Produto;
import br.com.loja_online.model.VendasRealizada;
import br.com.loja_online.repository.CarrinhoDeComprasRepository;
import br.com.loja_online.repository.VendasRealizadaRepository;


/**
 * @author CLAUDIO
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/vendas_realizadas")
public class VendasRealizadaController {
	
	@Autowired
	private VendasRealizadaRepository reposioritoDeVendas;
	
	@Autowired
	private CarrinhoDeComprasRepository carrinhoDeComprasRepository;

	
	
	private List<Produto> listaDeProdutos = new ArrayList<>();
	
	/**
	 * 
	 */
	public VendasRealizadaController() {}
	
	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

	@PostMapping("/{id_carrinho}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Produto> finalizarCompraDeProdutos(@PathVariable Long id_carrinho) {
		
		listaDeProdutos.clear();
		
		Optional<CarrinhoDeCompra> car = carrinhoDeComprasRepository
				.findById( id_carrinho );
		getListaDeProdutos().addAll( car.get().getListaDeProdutosDoCarrinho() );
		
		VendasRealizada vendasRealizada = new VendasRealizada();
		vendasRealizada.setPrimeiroNome( car.get().getClientesCadastrado().getPrimeiroNome() );
		vendasRealizada.setSobreNome( car.get().getClientesCadastrado().getSobreNome() );
		vendasRealizada.setNomeDeUsuario( car.get().getClientesCadastrado().getNomeDeUsuario() );
		vendasRealizada.setListaDeProdutosComprados(getListaDeProdutos());
		reposioritoDeVendas.save(vendasRealizada);
		
		List<Produto> lp = new ArrayList<>();
		lp.addAll( car.get().getListaDeProdutosDoCarrinho() );
		
		 car.get().getListaDeProdutosDoCarrinho()
		 .removeAll(  car.get().getListaDeProdutosDoCarrinho()  );
		 
		 carrinhoDeComprasRepository.save( car.get() );
		
		return lp;
	}

}