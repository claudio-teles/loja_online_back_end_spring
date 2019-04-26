package br.com.loja_online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.loja_online.model.AdministadorSite;

public interface AdministradorRepository extends JpaRepository<AdministadorSite, Long> {

}
