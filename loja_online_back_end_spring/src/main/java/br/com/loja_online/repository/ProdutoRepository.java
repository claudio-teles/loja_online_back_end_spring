/**
 * 
 */
package br.com.loja_online.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.loja_online.model.Produto;

/**
 * @author CLAUDIO
 *
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	@Query(value="SELECT \r\n" + 
			"  *" + 
			"FROM \r\n" + 
			"  esquema_loja_online.produto", nativeQuery=true)
	List<Produto> findAll();
}
