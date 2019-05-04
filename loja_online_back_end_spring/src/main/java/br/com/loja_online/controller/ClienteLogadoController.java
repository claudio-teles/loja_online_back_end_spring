/**
 * 
 */
package br.com.loja_online.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.CarrinhoDeCompra;
import br.com.loja_online.model.ClientesCadastrado;
import br.com.loja_online.model.ClientesLogado;
import br.com.loja_online.repository.CarrinhoDeComprasRepository;
import br.com.loja_online.repository.ClienteCadastradoRepository;
import br.com.loja_online.repository.ClienteLogadoRepository;

/**
 * @author CLAUDIO
 *
 */
@CrossOrigin
@RestController
@RequestMapping("api/clientes_logados")
public class ClienteLogadoController {
	
	private boolean statusClienteLogado = false;
	
	@Autowired
	private ClienteCadastradoRepository cadastradoRepository;
	
	@Autowired
	private ClienteLogadoRepository clienteLogadoRepository;
	
	@Autowired
	private CarrinhoDeComprasRepository carrinhoDeComprasRepository;
	
	private CarrinhoDeCompra carrinho;
	
	private ClientesLogado cliente;

	/**
	 * 
	 */
	public ClienteLogadoController() {}
	
	public CarrinhoDeCompra getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoDeCompra carrinho) {
		this.carrinho = carrinho;
	}

	public ClientesLogado getCliente() {
		return cliente;
	}

	public void setCliente(ClientesLogado cliente) {
		this.cliente = cliente;
	}

	@PutMapping @Transactional
	@ResponseStatus(HttpStatus.OK)
	public String fazerLogin(@RequestBody Map<String, String> loginJson) {
		
		if (statusClienteLogado == false) {
			
			List<String> listaDeUsuariosCadastrados = cadastradoRepository.findAllANomeDeUsuario( loginJson.get("nome_de_usuario") );
			List<String> listaDeSenhasDeUsuariosCadastrados = cadastradoRepository.findAllASenha( loginJson.get("senha_de_usuario") );
			
			boolean nomeDeUsuario = listaDeUsuariosCadastrados.contains( loginJson.get("nome_de_usuario") );
			boolean senhaDeUsuario = listaDeSenhasDeUsuariosCadastrados.contains( loginJson.get("senha_de_usuario") );
			
			
			if (nomeDeUsuario && senhaDeUsuario) {
				statusClienteLogado = true;
				System.out.println("nomeDeUsuario: "+nomeDeUsuario+".");
				System.out.println("senhaDeUsuario: "+senhaDeUsuario+".");
				ClientesLogado clienteLogado = clienteLogadoRepository.getOne( Long.parseLong( loginJson.get("id_cliente_logado")) );
				clienteLogado.setStatusClienteLogado(true);
				clienteLogadoRepository.save(clienteLogado);
				
				CarrinhoDeComprasController comprasController = new CarrinhoDeComprasController();
				comprasController.setClienteLogado(true);
				
				carrinho = new CarrinhoDeCompra();
				ClientesCadastrado cc = cadastradoRepository.getOne(
					Long.parseLong( loginJson.get("id_cliente_logado"))+ (long)1
				);
				carrinho.setClientesCadastrado(cc);
				carrinhoDeComprasRepository.save(carrinho);
				
				return (loginJson.get("nome_de_usuario")+", seja bem vindo a loja online de eletrônicos!");
			}
			
		}
		
		return "Não foi possível fazer o login, tente novamente!";
	}

}
