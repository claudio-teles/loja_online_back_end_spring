/**
 * 
 */
package br.com.loja_online.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja_online.model.CarrinhoDeCompra;
import br.com.loja_online.model.Produto;

/**
 * @author CLAUDIO
 *
 */
public interface CarrinhoDeComprasRepository extends JpaRepository<CarrinhoDeCompra, Long> {

	List<Produto> findByIdCarrinho(Long id_carrinho_de_compras);

}
