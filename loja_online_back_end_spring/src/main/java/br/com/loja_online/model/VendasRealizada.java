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
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_venda_realizada")
	private Long idVendaRealizadas;
	
	private String primeiroNome;
	private String sobreNome;
	private String nomeDeUsuario;
	
	@OneToMany(targetEntity = Produto.class)
	private List<Produto> listaDeProdutosComprados;

	/**
	 * 
	 */
	public VendasRealizada() {}

	public void setIdVendaRealizadas(Long idVendaRealizadas) {
		this.idVendaRealizadas = idVendaRealizadas;
	}

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

	public List<Produto> getListaDeProdutosComprados() {
		return listaDeProdutosComprados;
	}

	public void setListaDeProdutosComprados(List<Produto> listaDeProdutosComprados) {
		this.listaDeProdutosComprados = listaDeProdutosComprados;
	}

	public Long getIdVendaRealizadas() {
		return idVendaRealizadas;
	}


}
