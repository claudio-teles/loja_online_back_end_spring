/**
 * 
 */
package br.com.loja_online.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.loja_online.model.ClientesCadastrado;

/**
 * @author CLAUDIO
 *
 */
public interface ClienteCadastradoRepository extends JpaRepository<ClientesCadastrado, Long> {
	
	@Query(value="SELECT \r\n" + 
			"  nome_usuario\r\n" + 
			"FROM \r\n" + 
			"  esquema_loja_online.clientes_cadastrado", nativeQuery=true)
	List<String> findAllANomeDeUsuario(String string);
	
	@Query(value="SELECT \r\n" + 
			"  senha\r\n" + 
			"FROM \r\n" + 
			"  esquema_loja_online.clientes_cadastrado", nativeQuery=true)
	List<String> findAllASenha(String string);

}
