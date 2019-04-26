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
@NamedQuery(name = "clientesCadastrado.findAll", query = "SELECT c FROM ClientesCadastrado c")
@Table(name = "clientes_cadastrado")
public class ClientesCadastrado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 464980385951689573L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) @Column(name = "id_cliente")
	private Long idCliente;
	@Column(name = "primeiro_nome", nullable = false)
	private String primeiroNome;
	@Column(name = "sobre_nome", nullable = false)
	private String sobreNome;
	@Column(name = "nome_usuario", nullable = false)
	private String nomeDeUsuario;
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@Column(name = "rg", nullable = false)
	private String rg;
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "rua", nullable = false)
	private String rua;
	@Column(name = "numero_da_residencia", nullable = false)
	private String numeroResidencia;
	@Column(name = "complemento")
	private String complemento;
	@Column(name = "bairro", nullable = false)
	private String bairro;
	@Column(name = "cidade", nullable = false)
	private String cidade;
	@Column(name = "estado", nullable = false)
	private String estado;
	@Column(name = "pais", nullable = false)
	private String pais;
	
	@Column(name = "tipo_de_conta", nullable = false)
	private String tipoConta;
	@Column(name = "variacao")
	private String variacao;
	@Column(name = "bandeira", nullable = false)
	private String bandeira;
	@Column(name = "nome_da_conta", nullable = false)
	private String nomeConta;
	@Column(name = "numero_da_conta", nullable = false)
	private String numeroConta;
	@Column(name = "mes_validade_cartao", nullable = false)
	private String mesValidadeCartao;
	@Column(name = "ano_validade_cartao", nullable = false)
	private String anoValidadeCartao;
	
	@OneToMany(targetEntity = CarrinhoDeCompra.class)
	private List<CarrinhoDeCompra> listaDeCarrinhosDeCompras;
	
	public ClientesCadastrado() {
		super();
	}

	public ClientesCadastrado(String primeiroNome, String sobreNome, String nomeDeUsuario, String senha, String rg,
			String cpf, String rua, String numeroResidencia, String complemento, String bairro, String cidade,
			String estado, String pais, String tipoConta, String bandeira, String nomeConta, String numeroConta,
			String mesValidadeCartao, String anoValidadeCartao) {
		super();
		this.primeiroNome = primeiroNome;
		this.sobreNome = sobreNome;
		this.nomeDeUsuario = nomeDeUsuario;
		this.senha = senha;
		this.rg = rg;
		this.cpf = cpf;
		this.rua = rua;
		this.numeroResidencia = numeroResidencia;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.tipoConta = tipoConta;
		this.bandeira = bandeira;
		this.nomeConta = nomeConta;
		this.numeroConta = numeroConta;
		this.mesValidadeCartao = mesValidadeCartao;
		this.anoValidadeCartao = anoValidadeCartao;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumeroResidencia() {
		return numeroResidencia;
	}

	public void setNumeroResidencia(String numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getVariacao() {
		return variacao;
	}

	public void setVariacao(String variacao) {
		this.variacao = variacao;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getMesValidadeCartao() {
		return mesValidadeCartao;
	}

	public void setMesValidadeCartao(String mesValidadeCartao) {
		this.mesValidadeCartao = mesValidadeCartao;
	}

	public String getAnoValidadeCartao() {
		return anoValidadeCartao;
	}

	public void setAnoValidadeCartao(String anoValidadeCartao) {
		this.anoValidadeCartao = anoValidadeCartao;
	}

	public List<CarrinhoDeCompra> getListaDeCarrinhosDeCompras() {
		return listaDeCarrinhosDeCompras;
	}

	public void setListaDeCarrinhosDeCompras(List<CarrinhoDeCompra> listaDeCarrinhosDeCompras) {
		this.listaDeCarrinhosDeCompras = listaDeCarrinhosDeCompras;
	}

	@Override
	public String toString() {
		return "ClientesCadastrado [idCliente=" + idCliente + ", primeiroNome=" + primeiroNome + ", sobreNome="
				+ sobreNome + ", nomeDeUsuario=" + nomeDeUsuario + ", senha=" + senha + ", rg=" + rg + ", cpf=" + cpf
				+ ", rua=" + rua + ", numeroResidencia=" + numeroResidencia + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais + ", tipoConta="
				+ tipoConta + ", variacao=" + variacao + ", bandeira=" + bandeira + ", nomeConta=" + nomeConta
				+ ", numeroConta=" + numeroConta + ", mesValidadeCartao=" + mesValidadeCartao + ", anoValidadeCartao="
				+ anoValidadeCartao + ", listaDeCarrinhosDeCompras=" + listaDeCarrinhosDeCompras + "]";
	}
	
}