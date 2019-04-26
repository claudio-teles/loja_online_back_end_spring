/**
 * 
 */
package br.com.loja_online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja_online.model.Loja;

/**
 * @author CLAUDIO
 *
 */
public interface LojaRepository extends JpaRepository<Loja, Long> {

}
