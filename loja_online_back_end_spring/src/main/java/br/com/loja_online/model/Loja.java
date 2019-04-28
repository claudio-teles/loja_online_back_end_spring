/**
 * 
 */
package br.com.loja_online.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * @author CLAUDIO
 *
 */
@Entity
@NamedQuery(name = "Loja.findAll", query = "SELECT l FROM Loja l")
public class Loja implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7203551265807937457L;
	
	@Id @Column(name = "id_loja") @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idLoja;
	
	@Column(name = "nome_da_loja")
	private String nomeDaLoja = "";
	
	@OneToOne(targetEntity = Estoque.class)
	private Estoque estoque;

	/**
	 * 
	 */
	public Loja() {}

	/**
	 * @param estoque
	 */
	public Loja(Estoque estoque) {
		super();
		this.estoque = estoque;
	}

	public Long getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(Long idLoja) {
		this.idLoja = idLoja;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return "Loja [idLoja=" + idLoja + ", estoque=" + estoque + "]";
	}

}
