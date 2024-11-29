package br.com.rigo.portal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.rigo.portal.model.Categoria;
import br.com.rigo.portal.model.Noticia;


public interface NoticiaRepository extends CrudRepository<Noticia, Integer> {
    List<Noticia> findAllNoticiasByCategoria(Categoria categoria);
}
