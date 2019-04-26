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
@NamedQuery(name="liquidacao.findAll", query="SELECT l FROM Liquidacao l")
@Table(name = "liquidacoe")
public class Liquidacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8905057686188990612L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id_liquidacao")
	private Long idLiquidacao;
	
	@OneToMany(targetEntity = Produto.class)
	private List<Produto> listaDeProdutosEmLiquidacao;

	/**
	 * 
	 */
	public Liquidacao() {}

	public Long getIdLiquidacao() {
		return idLiquidacao;
	}

	public void setIdLiquidacao(Long idLiquidacao) {
		this.idLiquidacao = idLiquidacao;
	}

	public List<Produto> getListaDeProdutosEmLiquidacao() {
		return listaDeProdutosEmLiquidacao;
	}

	public void setListaDeProdutosEmLiquidacao(List<Produto> listaDeProdutosEmLiquidacao) {
		this.listaDeProdutosEmLiquidacao = listaDeProdutosEmLiquidacao;
	}

	@Override
	public String toString() {
		return "Liquidacao [idLiquidacao=" + idLiquidacao + ", listaDeProdutosEmLiquidacao="
				+ listaDeProdutosEmLiquidacao + "]";
	}

}
