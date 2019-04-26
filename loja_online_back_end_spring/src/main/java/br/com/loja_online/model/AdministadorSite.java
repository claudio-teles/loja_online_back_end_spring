package br.com.loja_online.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author CLAUDIO
 *
 */
@Entity @NamedQuery(name = "admistradorSite.findAll", query = "SELECT a FROM AdministadorSite a")
@Table(name = "administrador_do_site")
public class AdministadorSite implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2350692415324918097L;

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id_administrador")
	private Long idAdminstrador;
	
	@Column(name = "nome_do_adiminitrador")
	private String nomeDoAdiminitrador;
	@Column(name = "senha_do_adiminitrador")
	private String senhaDoAdiminitrador;
	@Column(name = "status_administrador_logado")
	private boolean statuAdministradorLogado = false;

	/**
	 * 
	 */
	public AdministadorSite() {}

	public AdministadorSite(String nomeDoAdiminitrador, String senhaDoAdiminitrador) {
		super();
		this.nomeDoAdiminitrador = nomeDoAdiminitrador;
		this.senhaDoAdiminitrador = senhaDoAdiminitrador;
	}

	public Long getIdAdminstrador() {
		return idAdminstrador;
	}

	public void setIdAdminstrador(Long idAdminstrador) {
		this.idAdminstrador = idAdminstrador;
	}

	public String getNomeDoAdiminitrador() {
		return nomeDoAdiminitrador;
	}

	public void setNomeDoAdiminitrador(String nomeDoAdiminitrador) {
		this.nomeDoAdiminitrador = nomeDoAdiminitrador;
	}

	public String getSenhaDoAdiminitrador() {
		return senhaDoAdiminitrador;
	}

	public void setSenhaDoAdiminitrador(String senhaDoAdiminitrador) {
		this.senhaDoAdiminitrador = senhaDoAdiminitrador;
	}

	public boolean isStatuAdministradorLogado() {
		return statuAdministradorLogado;
	}

	public void setStatuAdministradorLogado(boolean statuAdministradorLogado) {
		this.statuAdministradorLogado = statuAdministradorLogado;
	}

}
