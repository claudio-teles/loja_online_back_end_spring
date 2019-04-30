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
@Table(name="carrinho_de_compra")
@NamedQuery(name="carrinhoDeCompra.findAll", query="SELECT c FROM CarrinhoDeCompra c")
public class CarrinhoDeCompra implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7218419652353042480L;
	
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id_carrinho")
	private Long idCarrinho;
	
	@OneToOne(targetEntity = ClientesCadastrado.class)
	private ClientesCadastrado clientesCadastrado;
	
	@OneToMany(targetEntity = Produto.class) @Column(name = "lista_de_produtos_do_carrinho")
	private List<Produto> listaDeProdutosDoCarrinho;

	public CarrinhoDeCompra() {}

	/**
	 * @param clientesCadastrado
	 * @param listaDeProdutosDoCarrinho
	 */
	public CarrinhoDeCompra(ClientesCadastrado clientesCadastrado, List<Produto> listaDeProdutosDoCarrinho) {
		super();
		this.clientesCadastrado = clientesCadastrado;
		this.listaDeProdutosDoCarrinho = listaDeProdutosDoCarrinho;
	}

	public Long getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public ClientesCadastrado getClientesCadastrado() {
		return clientesCadastrado;
	}

	public void setClientesCadastrado(ClientesCadastrado clientesCadastrado) {
		this.clientesCadastrado = clientesCadastrado;
	}

	public List<Produto> getListaDeProdutosDoCarrinho() {
		return listaDeProdutosDoCarrinho;
	}

	public void setListaDeProdutosDoCarrinho(List<Produto> listaDeProdutosDoCarrinho) {
		this.listaDeProdutosDoCarrinho = listaDeProdutosDoCarrinho;
	}

	@Override
	public String toString() {
		return "CarrinhoDeCompra [idCarrinho=" + idCarrinho + ", clientesCadastrado=" + clientesCadastrado
				+ ", listaDeProdutosDoCarrinho=" + listaDeProdutosDoCarrinho + "]";
	}

}
