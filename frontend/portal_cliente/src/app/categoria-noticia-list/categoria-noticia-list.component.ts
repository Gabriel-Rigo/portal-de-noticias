import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PortalService } from '../services/portal.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-categoria-noticia-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './categoria-noticia-list.component.html',
  styleUrls: ['./categoria-noticia-list.component.css'],
})
export class CategoriaNoticiaListComponent implements OnInit {
  noticias: any[] = [];
  categoriaId: number | null = null;
  categoriaNome: string = '';
  categoriaDesc: string = '';

  constructor(private portalService: PortalService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    // Captura o ID da categoria a partir da URL
    this.categoriaId = Number(this.route.snapshot.paramMap.get('id'));

    // Chama o serviço para buscar as notícias da categoria
    if (this.categoriaId) {
      this.portalService.listarNoticiasPorCategoria(this.categoriaId).subscribe((data) => {
        this.noticias = data;
      });
    }
        // Busca o nome da categoria
        this.portalService.obterCategoria(this.categoriaId).subscribe((categoria) => {
          this.categoriaNome = categoria.nome;
        });

        // Busca a descrição da categoria
        this.portalService.obterCategoria(this.categoriaId).subscribe((categoria) => {
          this.categoriaDesc = categoria.descricao;
        });
  }
}
