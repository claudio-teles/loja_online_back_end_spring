/**
 * 
 */
package br.com.loja_online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja_online.model.ClientesLogado;

/**
 * @author CLAUDIO
 *
 */
public interface ClienteLogadoRepository extends JpaRepository<ClientesLogado, Long> {

}
