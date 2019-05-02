/**
 * 
 */
package br.com.loja_online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loja_online.model.CarrinhoDeCompra;

/**
 * @author CLAUDIO
 *
 */
@Repository
public interface CarrinhoDeComprasRepository extends JpaRepository<CarrinhoDeCompra, Long> {

}
