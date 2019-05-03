package br.com.loja_online.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("api/clientes_cadastrados")
public class ClientesCadastradosController {
	
	@Autowired
	private ClienteCadastradoRepository repositorioClientesCadastrado;
	
	@Autowired
	private ClienteLogadoRepository clienteLogadoRepository;
	
	private String primeiroNome;
	private String sobreNome;
	private String nomeDeUsuario;

	/**
	 * 
	 */
	public ClientesCadastradosController() {}
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}

	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClientesCadastrado cadastrarUmCliente(@RequestBody Map<String, String> cadastroJson) {
		
		ClientesCadastrado clienteCadastrado = new ClientesCadastrado();
		clienteCadastrado.setPrimeiroNome( cadastroJson.get( "primeiro_nome" ) );
		clienteCadastrado.setSobreNome( cadastroJson.get( "sobre_nome" ) );
		clienteCadastrado.setNomeDeUsuario( cadastroJson.get( "nome_de_usuario" ) );
		clienteCadastrado.setSenha( cadastroJson.get( "senha" ) );
		
		clienteCadastrado.setRg( cadastroJson.get( "rg" ) );
		clienteCadastrado.setCpf( cadastroJson.get( "cpf" ) );
		
		clienteCadastrado.setRua( cadastroJson.get( "rua" ) );
		clienteCadastrado.setNumeroResidencia( cadastroJson.get( "numero_da_residencia" ) );
		clienteCadastrado.setComplemento( cadastroJson.get( "complemento" ) );
		clienteCadastrado.setBairro( cadastroJson.get( "bairro" ) );
		clienteCadastrado.setCidade( cadastroJson.get( "cidade" ) );
		clienteCadastrado.setEstado( cadastroJson.get( "estado" ) );
		clienteCadastrado.setPais( cadastroJson.get( "pais" ) );
		
		clienteCadastrado.setTipoConta( cadastroJson.get( "tipo_de_conta" ) );
		clienteCadastrado.setVariacao( cadastroJson.get( "variacao" ) );
		clienteCadastrado.setBandeira( cadastroJson.get( "bandeira" ) );
		clienteCadastrado.setNomeConta( cadastroJson.get( "nome_da_conta" ) );
		clienteCadastrado.setNumeroConta( cadastroJson.get( "numero_da_conta" ) );
		clienteCadastrado.setMesValidadeCartao( cadastroJson.get( "mes" ) );
		clienteCadastrado.setAnoValidadeCartao( cadastroJson.get( "ano" ) );
		
		setPrimeiroNome( cadastroJson.get( "primeiro_nome" ) );
		setSobreNome( cadastroJson.get( "sobre_nome" ) );
		setNomeDeUsuario( cadastroJson.get( "nome_de_usuario" ) );
		
		ClientesLogado clienteLogado = new ClientesLogado();
		clienteLogado.setStatusClienteLogado(false);
		
		clienteLogadoRepository.save(clienteLogado);
		
		repositorioClientesCadastrado.save(clienteCadastrado);
		
		return clienteCadastrado;
	}

}
