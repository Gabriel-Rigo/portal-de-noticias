package br.com.rigo.portal.repository;


import org.springframework.data.repository.CrudRepository;

import br.com.rigo.portal.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

}