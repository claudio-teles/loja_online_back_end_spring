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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	
	@OneToMany(targetEntity = Produto.class)
	private List<Produto> listaDeProdutosDoEstoque;
	
	@OneToOne(targetEntity = ItensTambemVisto.class)
	private ItensTambemVisto itensVistos;
	
	@OneToOne(targetEntity = Liquidacao.class)
	private Liquidacao liquidacao;

	/**
	 * 
	 */
	public Estoque() {}

	/**
	 * @param listaDeProdutosDoEstoque
	 * @param itensVistos
	 * @param liquidacao
	 */
	public Estoque(List<Produto> listaDeProdutosDoEstoque, ItensTambemVisto itensVistos, Liquidacao liquidacao) {
		super();
		this.listaDeProdutosDoEstoque = listaDeProdutosDoEstoque;
		this.itensVistos = itensVistos;
		this.liquidacao = liquidacao;
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

	public ItensTambemVisto getItensVistos() {
		return itensVistos;
	}

	public void setItensVistos(ItensTambemVisto itensVistos) {
		this.itensVistos = itensVistos;
	}

	public Liquidacao getLiquidacao() {
		return liquidacao;
	}

	public void setLiquidacao(Liquidacao liquidacao) {
		this.liquidacao = liquidacao;
	}

}
