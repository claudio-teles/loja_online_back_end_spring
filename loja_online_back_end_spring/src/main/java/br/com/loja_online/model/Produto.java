package br.com.loja_online.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author CLAUDIO
 *
 */
@Entity @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQuery(name="produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4445239464220531263L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id_produto")
	private Long idProduto;

	@Column(name="codigo_barra", nullable = false)
	private Long codigoBarra;
	
	@Column(name="nome_produto", nullable = false)
	private String nomeProduto;
	
	@Column(name="valor_produto", nullable = false)
	private float valorProduto;
	
	@Column(name = "quantidade_produto", nullable = false)
	private String quantidadeProduto;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(nullable = false)
	private float garantia;
	
	
	private String avaliacao;

	private String curtiu;

	@Column(name="nao_curtiu")
	private String naoCurtiu;
	
	@OneToOne(targetEntity = ImagemDoProduto.class)
	private ImagemDoProduto imagemDoProduto;

	/**
	 * 
	 */
	public Produto() {}

	/**
	 * @param codigoBarra
	 * @param nomeProduto
	 * @param valorProduto
	 * @param quantidadeProduto
	 * @param marca
	 * @param garantia
	 * @param imagemDoProduto
	 */
	public Produto(Long codigoBarra, String nomeProduto, float valorProduto, String quantidadeProduto, String marca,
			float garantia, ImagemDoProduto imagemDoProduto) {
		super();
		this.codigoBarra = codigoBarra;
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.quantidadeProduto = quantidadeProduto;
		this.marca = marca;
		this.garantia = garantia;
		this.imagemDoProduto = imagemDoProduto;
	}

	/**
	 * @param codigoBarra
	 * @param nomeProduto
	 * @param valorProduto
	 * @param quantidadeProduto
	 * @param marca
	 * @param descricao
	 * @param garantia
	 * @param avaliacao
	 * @param curtiu
	 * @param naoCurtiu
	 * @param imagemDoProduto
	 */
	public Produto(Long codigoBarra, String nomeProduto, float valorProduto, String quantidadeProduto, String marca,
			String descricao, float garantia, String avaliacao, String curtiu, String naoCurtiu,
			ImagemDoProduto imagemDoProduto) {
		super();
		this.codigoBarra = codigoBarra;
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.quantidadeProduto = quantidadeProduto;
		this.marca = marca;
		this.descricao = descricao;
		this.garantia = garantia;
		this.avaliacao = avaliacao;
		this.curtiu = curtiu;
		this.naoCurtiu = naoCurtiu;
		this.imagemDoProduto = imagemDoProduto;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(Long codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public float getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(float valorProduto) {
		this.valorProduto = valorProduto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getGarantia() {
		return garantia;
	}

	public void setGarantia(float garantia) {
		this.garantia = garantia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public String setAvaliacao(String avaliacao) {
		return this.avaliacao = avaliacao;
	}

	public ImagemDoProduto getImagemDoProduto() {
		return imagemDoProduto;
	}

	public String getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(String quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public String getCurtiu() {
		return curtiu;
	}

	public void setCurtiu(String curtiu) {
		this.curtiu = curtiu;
	}

	public String getNaoCurtiu() {
		return naoCurtiu;
	}

	public void setNaoCurtiu(String naoCurtiu) {
		this.naoCurtiu = naoCurtiu;
	}

	public void setImagemDoProduto(ImagemDoProduto imagemDoProduto) {
		this.imagemDoProduto = imagemDoProduto;
	}

}
