/**
 * 
 */
package br.com.loja_online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja_online.model.Estoque;

/**
 * @author CLAUDIO
 *
 */
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
