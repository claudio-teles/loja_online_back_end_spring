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
@Table(name="itens_tambem_visto")
@NamedQuery(name="itensTambemVisto.findAll", query="SELECT i FROM ItensTambemVisto i")
public class ItensTambemVisto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1775104833927917886L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id_itens")
	private Long idItens;
	
	@OneToMany(targetEntity = Produto.class)
	private List<Produto> listaDeItensTambemVistos;

	/**
	 * 
	 */
	public ItensTambemVisto() {}

	/**
	 * @param listaItensTambemVistos
	 */
	public ItensTambemVisto(List<Produto> listaDeItensTambemVistos) {
		super();
		this.listaDeItensTambemVistos = listaDeItensTambemVistos;
	}

	public Long getIdItens() {
		return idItens;
	}

	public void setIdItens(Long idItens) {
		this.idItens = idItens;
	}

	public List<Produto> getlistaDeItensTambemVistos() {
		return listaDeItensTambemVistos;
	}

	public void setlistaDeItensTambemVistos(List<Produto> listaDeItensTambemVistos) {
		this.listaDeItensTambemVistos = listaDeItensTambemVistos;
	}

	@Override
	public String toString() {
		return "ItensTambemVisto [idItens=" + idItens + ", listaDeItensTambemVistos=" + listaDeItensTambemVistos + "]";
	}

}
