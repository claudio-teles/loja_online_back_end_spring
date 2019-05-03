/**
 * 
 */
package br.com.loja_online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loja_online.model.VendasRealizada;

/**
 * @author CLAUDIO
 *
 */
@Repository
public interface VendasRealizadaRepository extends JpaRepository<VendasRealizada, Long> {

}
