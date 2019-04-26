package br.com.loja_online.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author CLAUDIO
 *
 */
@Entity @Table(name = "clientes_logado")
@NamedQuery(name = "clienteLogado", query = "SELECT c FROM ClientesLogado c")
public class ClientesLogado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3307565501110490585L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id_cliente_logado")
	private Long idClienteLogado;
	
	@OneToOne(targetEntity = ClientesCadastrado.class)
	private ClientesCadastrado fkClienteCadastrado;
	
	@Column(name = "status_cliente_logado")
	private boolean statusClienteLogado = false;

	/**
	 * 
	 */
	public ClientesLogado() {}

	public Long getIdClienteLogado() {
		return idClienteLogado;
	}

	public void setIdClienteLogado(Long idClienteLogado) {
		this.idClienteLogado = idClienteLogado;
	}

	public ClientesCadastrado getFkClienteCadastrado() {
		return fkClienteCadastrado;
	}

	public void setFkClienteCadastrado(ClientesCadastrado fkClienteCadastrado) {
		this.fkClienteCadastrado = fkClienteCadastrado;
	}

	public boolean getStatusClienteLogado() {
		return statusClienteLogado;
	}

	public void setStatusClienteLogado(boolean statusClienteLogado) {
		this.statusClienteLogado = statusClienteLogado;
	}

	@Override
	public String toString() {
		return "ClientesLogado [idClienteLogado=" + idClienteLogado + ", fkClienteCadastrado=" + fkClienteCadastrado
				+ ", statusClienteLogado=" + statusClienteLogado + "]";
	}

}
