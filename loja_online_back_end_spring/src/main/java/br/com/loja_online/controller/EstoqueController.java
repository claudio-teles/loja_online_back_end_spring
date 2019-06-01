/**
 * 
 */
package br.com.loja_online.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_online.model.Estoque;
import br.com.loja_online.repository.EstoqueRepository;

/**
 * @author CLAUDIO
 *
 */
@CrossOrigin
@RestController @RequestMapping("/estoques")
public class EstoqueController {
	
	@Autowired
	private EstoqueRepository estoqueRepository;

	/**
	 * 
	 */
	public EstoqueController() {}
	
	@GetMapping("/{id_estoque}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Estoque> exibirEstoqueDaLoja(@PathVariable Long id_estoque) {
		return estoqueRepository.findById(id_estoque);
	}

}
