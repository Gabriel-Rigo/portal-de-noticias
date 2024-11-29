package br.com.rigo.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rigo.portal.model.Categoria;
import br.com.rigo.portal.model.Noticia;
import br.com.rigo.portal.repository.CategoriaRepository;
import br.com.rigo.portal.repository.NoticiaRepository;

@RestController
@RequestMapping(value = "noticia")
public class NoticiaController extends GenericController<Noticia, Integer>{

    @Autowired
    NoticiaRepository noticiaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @RequestMapping(value = "listarNoticiasPorCategoria/{id_categoria}", method = RequestMethod.GET)
    public ResponseEntity<List<Noticia>> listarNoticiasPorCategoria(@PathVariable(value="id_categoria") Integer id_categoria){
        Categoria categoria = categoriaRepository.findById(id_categoria).get();
        return ResponseEntity.ok((List<Noticia>) noticiaRepository.findAllNoticiasByCategoria(categoria));
    }
}
