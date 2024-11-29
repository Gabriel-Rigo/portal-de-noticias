package br.com.rigo.portal.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.rigo.portal.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer>{

}
