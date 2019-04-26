/**
 * 
 */
package br.com.loja_online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja_online.model.ClientesCadastrado;

/**
 * @author CLAUDIO
 *
 */
public interface ClienteCadastradoRepository extends JpaRepository<ClientesCadastrado, Long> {

}
