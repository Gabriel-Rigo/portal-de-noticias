import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router'; // Necessário para o routerLink funcionar
import { PortalService } from '../services/portal.service';

@Component({
  selector: 'app-noticia-list',
  standalone: true,
  imports: [CommonModule, RouterModule], // Adicione os módulos necessários
  templateUrl: './noticia-list.component.html',
  styleUrls: ['./noticia-list.component.css'],
})
export class NoticiaListComponent implements OnInit {
  noticias: any[] = [];

  constructor(private portalService: PortalService) {}

  ngOnInit(): void {
    this.portalService.listarNoticias().subscribe((data) => {
      this.noticias = data;
    });
  }
}
