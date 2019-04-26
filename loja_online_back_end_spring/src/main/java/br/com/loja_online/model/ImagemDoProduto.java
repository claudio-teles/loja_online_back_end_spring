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
@Entity
@Table(name="imagem_do_produto")
@NamedQuery(name="imagemDoProduto.findAll", query="SELECT i FROM ImagemDoProduto i")
public class ImagemDoProduto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4893922112317375458L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idImagem;
	@Column(name = "local_da_imagem", nullable = false)
	private String localDaImagem;

	/**
	 * 
	 */
	public ImagemDoProduto() {}

	public Long getIdImagem() {
		return idImagem;
	}

	public void setIdImagem(Long idImagem) {
		this.idImagem = idImagem;
	}

	public String getLocalDaImagem() {
		return localDaImagem;
	}

	public void setLocalDaImagem(String localDaImagem) {
		this.localDaImagem = localDaImagem;
	}

	@Override
	public String toString() {
		return "ImagemDoProduto [idImagem=" + idImagem + ", localDaImagem=" + localDaImagem + "]";
	}

}
