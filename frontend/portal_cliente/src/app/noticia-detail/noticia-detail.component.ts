import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PortalService } from '../services/portal.service';

@Component({
  selector: 'app-noticia-detail',
  templateUrl: './noticia-detail.component.html',
  styleUrls: ['./noticia-detail.component.css'],
})
export class NoticiaDetailComponent implements OnInit {
  noticia: any;

  constructor(
    private route: ActivatedRoute,
    private portalService: PortalService
  ) {}

  ngOnInit(): void {
    // Obter o ID da rota
    const id = this.route.snapshot.params['id'];

    // Buscar os detalhes da notícia
    this.portalService.obterNoticia(id).subscribe((data) => {
      this.noticia = data;
    });
  }
}
