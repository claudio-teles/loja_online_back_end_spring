package br.com.loja_online.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author CLAUDIO
 *
 */
@Entity
@Table(name = "vendas_realizada")
@NamedQuery(name = "vendasRealizada.findAll", query = "SELECT v FROM VendasRealizada v")
public class VendasRealizada implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7403371820126142464L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id_venda_realizada")
	private Long idVendaRealizadas;
	
	@OneToOne(targetEntity = ClientesCadastrado.class)
	private ClientesCadastrado clienteCadastrado;
	
	@OneToMany(targetEntity = Produto.class)
	private List<Produto> listaDeProdutosComprados;

	/**
	 * 
	 */
	public VendasRealizada() {}

	public void setIdVendaRealizadas(Long idVendaRealizadas) {
		this.idVendaRealizadas = idVendaRealizadas;
	}

	public List<Produto> getListaDeProdutosComprados() {
		return listaDeProdutosComprados;
	}

	public ClientesCadastrado getClienteCadastrado() {
		return clienteCadastrado;
	}

	public void setClienteCadastrado(ClientesCadastrado clienteCadastrado) {
		this.clienteCadastrado = clienteCadastrado;
	}

	public void setListaDeProdutosComprados(List<Produto> listaDeProdutosComprados) {
		this.listaDeProdutosComprados = listaDeProdutosComprados;
	}

	public Long getIdVendaRealizadas() {
		return idVendaRealizadas;
	}

}
