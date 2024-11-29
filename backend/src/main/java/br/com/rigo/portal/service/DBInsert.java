package br.com.rigo.portal.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.rigo.portal.model.Categoria;
import br.com.rigo.portal.model.Noticia;
import br.com.rigo.portal.model.Pessoa;
import br.com.rigo.portal.repository.CategoriaRepository;
import br.com.rigo.portal.repository.NoticiaRepository;
import br.com.rigo.portal.repository.PessoaRepository;

@Component
public class DBInsert implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    NoticiaRepository noticiaRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria("Lançamentos de Jogos", "Fique por dentro dos últimos lançamentos no mundo dos jogos", null, true);
        categoriaRepository.save(cat1);
        Categoria cat2 = new Categoria("Jogos de Ação", "Notícias sobre os melhores jogos de ação", null, true);
        categoriaRepository.save(cat2);
        // Categorias Filhas
        Categoria cat3 = new Categoria("Jogos de RPG", "Tudo sobre o universo dos jogos de RPG", null, true);
        categoriaRepository.save(cat3);
        Categoria cat4 = new Categoria("Esportes Eletrônicos", "Competições e torneios de esportes digitais", null, true);
        categoriaRepository.save(cat4);
        Categoria cat5 = new Categoria("Jogos Indie", "Destaques para jogos independentes e criativos", null, true);
        categoriaRepository.save(cat5);
        Categoria cat6 = new Categoria("Jogos de Aventura", "Explorações e aventuras nos jogos mais imersivos", null, false);
        categoriaRepository.save(cat6);
        Categoria cat7 = new Categoria("Jogos Multiplayer", "Tudo sobre jogos online e interativos", null, false);
        categoriaRepository.save(cat7);
        Categoria cat8 = new Categoria("Games Mobile", "Notícias sobre jogos para celular e tablet", cat1, false);
        categoriaRepository.save(cat8);
        Categoria cat9 = new Categoria("Jogos de Estratégia", "Tudo sobre jogos de estratégia, gestão e táticas", cat8, false);
        categoriaRepository.save(cat9);
        Categoria cat10 = new Categoria("Simuladores", "Destaques para jogos de simulação realista", cat8, false);
        categoriaRepository.save(cat10);

        List<Categoria> cats = Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10);

         // Gerador de números aleatórios
        Random random = new Random();

        // Criação das 20 instâncias de Noticia com valores aleatórios
        for (int i = 1; i <= 20; i++) {
            Noticia noticia = new Noticia();

            // Geração de valores aleatórios para os atributos            
            noticia.setTitulo("Notícia do Jogo " + (random.nextInt(100) + 1));
            noticia.setCorpo("Este é o corpo da notícia número " + i + ", com detalhes sobre o jogo " + (random.nextInt(50) + 1) + ".");

            // Data aleatória para publicação
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, -random.nextInt(365)); // data no último ano
            noticia.setData_publicacao(LocalDateTime.now());

            // URL de imagem aleatória
            noticia.setImagem_url("https://picsum.photos/id/"+ (random.nextInt(50) + 1) + "/200/300");

            // Escolhe uma categoria aleatória
            noticia.setCategoria(cats.get(random.nextInt(cats.size())));

            // Adiciona a instância de Noticia na lista
            noticiaRepository.save(noticia);
        }

        // Criando pessoas com nomes relacionados ao mundo dos jogos
        Pessoa p1 = new Pessoa("Nathália Gamer");
        pessoaRepository.save(p1);
        Pessoa p2 = new Pessoa("Lucas PowerUp");
        pessoaRepository.save(p2);
        Pessoa p3 = new Pessoa("João Knight");
        pessoaRepository.save(p3);
        Pessoa p4 = new Pessoa("Aline Pixel");
        pessoaRepository.save(p4);
        Pessoa p5 = new Pessoa("Carlos Controller");
        pessoaRepository.save(p5);
        Pessoa p6 = new Pessoa("Roberta Joystick");
        pessoaRepository.save(p6);
        Pessoa p7 = new Pessoa("Victor Boss");
        pessoaRepository.save(p7);
        Pessoa p8 = new Pessoa("Juliana PixelArt");
        pessoaRepository.save(p8);
        Pessoa p9 = new Pessoa("Felipe Streamer");
        pessoaRepository.save(p9);
        Pessoa p10 = new Pessoa("Mariana GamerGirl");
        pessoaRepository.save(p10);

        System.out.println("----------All Game-related Data saved into Database----------------------");
    }
}
