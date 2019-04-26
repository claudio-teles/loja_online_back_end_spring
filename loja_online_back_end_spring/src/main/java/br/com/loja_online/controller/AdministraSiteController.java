package br.com.loja_online.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.AdministadorSite;
import br.com.loja_online.model.VendasRealizada;
import br.com.loja_online.repository.AdministradorRepository;
import br.com.loja_online.repository.VendasRealizadaRepository;


/**
 * @author CLAUDIO
 *
 */
@RestController
@RequestMapping("api/administrador_do_sites")
public class AdministraSiteController {
	
	@Autowired
	private AdministradorRepository repositorioDeAdministradores;
	
	@Autowired
	private VendasRealizadaRepository repositorioDeVendas;
	private boolean administradorLogado = false;

	private Long idDoAdministrador;

	/**
	 * 
	 */
	public AdministraSiteController() {}
	
	public boolean getAdministradorLogado() {
		return administradorLogado;
	}

	public void setAdministradorLogado(boolean administradorLogado) {
		this.administradorLogado = administradorLogado;
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public String fazerLoginAdministrador(@RequestBody Map<String, String> adiminstradorJson) {
		
		if (administradorLogado == false) {
			
			List<AdministadorSite> listaDeTodosOsAdministradores = repositorioDeAdministradores.findAll();
			Object nome = adiminstradorJson.get( "nome" );
			Object senha = adiminstradorJson.get( "senha" );
			idDoAdministrador = Long.parseLong( adiminstradorJson.get("id_do_administrador") );
			boolean nomeDoAdministrador = listaDeTodosOsAdministradores.contains( nome );
			boolean senhaDoAdministrador = listaDeTodosOsAdministradores.contains( senha );
			
			if (nomeDoAdministrador && senhaDoAdministrador) {
				administradorLogado = true;
				
				AdministadorSite administador = new AdministadorSite();
				administador = repositorioDeAdministradores.getOne( Long.parseLong( adiminstradorJson.get("id_do_administrador") ) );
				administador.setStatuAdministradorLogado(true);
				
				repositorioDeAdministradores.save(administador);
				
				return (adiminstradorJson.get( "nome" )+", bem vindo!");
			}
			
		}
		
		return "Usuário ou senha incorreta, tente novamente!";
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public String fazerLoffAdministrador() {
		
		if (administradorLogado == true) {
			
			administradorLogado = false;
			
			AdministadorSite administador = new AdministadorSite();
			administador = repositorioDeAdministradores.getOne( idDoAdministrador );
			administador.setStatuAdministradorLogado(false);
			
			repositorioDeAdministradores.save(administador);
			
			
		}
		
		return "Você está deslogado!";
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<VendasRealizada> listarAsVendasRealizadas() {
		
		if (getAdministradorLogado() == true) {
			return repositorioDeVendas.findAll();
		}
		
		return null;
	}

}
