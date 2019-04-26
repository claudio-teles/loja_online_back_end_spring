/**
 * 
 */
package br.com.loja_online.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @author CLAUDIO
 *
 */
@Entity
@NamedQuery(name = "Estoque.findAll", query = "SELECT e FROM Estoque e")
public class Estoque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7083062103648863820L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id_estoque")
	private Long idEstoque;
	
	private List<Produto> listaDeProdutosDoEstoque;
	
	private List<ItensTambemVisto> itensVistos;
	
	private List<Liquidacao> liquidacao;

	/**
	 * 
	 */
	public Estoque() {}

	/**
	 * @param listaDeProdutosDoEstoque
	 * @param itensVistos
	 */
	public Estoque(List<Produto> listaDeProdutosDoEstoque, List<ItensTambemVisto> itensVistos) {
		super();
		this.listaDeProdutosDoEstoque = listaDeProdutosDoEstoque;
		this.itensVistos = itensVistos;
	}

	public Long getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Long idEstoque) {
		this.idEstoque = idEstoque;
	}

	public List<Produto> getListaDeProdutosDoEstoque() {
		return listaDeProdutosDoEstoque;
	}

	public void setListaDeProdutosDoEstoque(List<Produto> listaDeProdutosDoEstoque) {
		this.listaDeProdutosDoEstoque = listaDeProdutosDoEstoque;
	}

	public List<ItensTambemVisto> getItensVistos() {
		return itensVistos;
	}

	public void setItensVistos(List<ItensTambemVisto> itensVistos) {
		this.itensVistos = itensVistos;
	}

	public List<Liquidacao> getLiquidacao() {
		return liquidacao;
	}

	public void setLiquidacao(List<Liquidacao> liquidacao) {
		this.liquidacao = liquidacao;
	}

	@Override
	public String toString() {
		return "Estoque [idEstoque=" + idEstoque + ", listaDeProdutosDoEstoque=" + listaDeProdutosDoEstoque
				+ ", itensVistos=" + itensVistos + "]";
	}

}
