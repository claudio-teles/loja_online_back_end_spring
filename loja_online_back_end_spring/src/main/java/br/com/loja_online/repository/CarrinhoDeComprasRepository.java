/**
 * 
 */
package br.com.loja_online.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja_online.model.CarrinhoDeCompra;

/**
 * @author CLAUDIO
 *
 */
public interface CarrinhoDeComprasRepository extends JpaRepository<CarrinhoDeCompra, Long> {

	Optional<CarrinhoDeCompra> findById(Long id);

}
