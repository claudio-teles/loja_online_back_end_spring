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
	private int quantidadeProduto;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(nullable = false)
	private float garantia;
	
	
	private String avaliacao;

	private Integer curtiu;

	@Column(name="nao_curtiu")
	private Integer naoCurtiu;
	
	@OneToOne(targetEntity = ImagemDoProduto.class)
	private ImagemDoProduto imagemDoProduto;

	/**
	 * 
	 */
	public Produto() {}

	public Produto(Long codigoBarra, String nomeProduto, float valorProduto, int quantidadeProduto,
			String marca, String descricao, float garantia) {
		super();
		this.codigoBarra = codigoBarra;
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.quantidadeProduto = quantidadeProduto;
		this.marca = marca;
		this.descricao = descricao;
		this.garantia = garantia;
	}

	public Produto(Long codigoBarra, String nomeProduto, float valorProduto, int quantidadeProduto,
			String marca, String descricao, float garantia, String avaliacao, Integer curtiu, Integer naoCurtiu) {
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

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
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

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Integer getCurtiu() {
		return curtiu;
	}

	public void setCurtiu(Integer curtiu) {
		this.curtiu = curtiu;
	}

	public Integer getNaoCurtiu() {
		return naoCurtiu;
	}

	public void setNaoCurtiu(Integer naoCurtiu) {
		this.naoCurtiu = naoCurtiu;
	}

	public ImagemDoProduto getImagemDoProduto() {
		return imagemDoProduto;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", codigoBarra=" + codigoBarra + ", nomeProduto=" + nomeProduto
				+ ", valorProduto=" + valorProduto + ", quantidadeProduto=" + quantidadeProduto + ", marca=" + marca
				+ ", descricao=" + descricao + ", garantia=" + garantia + ", avaliacao=" + avaliacao + ", curtiu="
				+ curtiu + ", naoCurtiu=" + naoCurtiu + ", imagemDoProduto=" + imagemDoProduto + "]";
	}

}
