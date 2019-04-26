/**
 * 
 */
package br.com.loja_online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja_online.model.Produto;

/**
 * @author CLAUDIO
 *
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
