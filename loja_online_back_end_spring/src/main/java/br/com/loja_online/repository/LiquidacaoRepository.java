/**
 * 
 */
package br.com.loja_online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja_online.model.Liquidacao;

/**
 * @author CLAUDIO
 *
 */
public interface LiquidacaoRepository extends JpaRepository<Liquidacao, Long> {

}
