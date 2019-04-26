/**
 * 
 */
package br.com.loja_online.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.ClientesCadastrado;
import br.com.loja_online.model.ClientesLogado;
import br.com.loja_online.repository.ClienteCadastradoRepository;
import br.com.loja_online.repository.ClienteLogadoRepository;

/**
 * @author CLAUDIO
 *
 */
@RestController
@RequestMapping("api/clientes_logados")
public class ClienteLogadoController {
	
	private boolean statusClienteLogado = false;
	
	@Autowired
	private ClienteCadastradoRepository cadastradoRepository;
	
	@Autowired
	private ClienteLogadoRepository clienteLogadoRepository;

	/**
	 * 
	 */
	public ClienteLogadoController() {}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public String fazerLogin(@RequestBody Map<String, String> loginJson) {
		
		if (statusClienteLogado == false) {
			
			List<ClientesCadastrado> clientesCadastrados = cadastradoRepository.findAll();
			Object nome = loginJson.get("nome_de_usuario");
			Object senha = loginJson.get("senha_de_usuario");
			boolean nomeDeUsuario = clientesCadastrados.contains(nome);
			boolean senhaDeUsuario = clientesCadastrados.contains(senha);
			
			if (nomeDeUsuario && senhaDeUsuario) {
				statusClienteLogado = true;
				ClientesLogado clienteLogado = clienteLogadoRepository.getOne( Long.parseLong( loginJson.get("id_do_usuario") ) );
				clienteLogado.setStatusClienteLogado(true);
				clienteLogadoRepository.save(clienteLogado);
				
				return (loginJson.get("nome_de_usuario")+", seja bem vindo a loja online de eletrônicos!");
			}
			
		}
		
		return "Não foi possível fazer o login, tente novamente!";
	}

}
