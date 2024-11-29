import { Component, OnInit } from '@angular/core';
import { PortalService } from '../services/portal.service';

@Component({
  selector: 'app-categoria-list',
  templateUrl: './categoria-list.component.html',
  styleUrls: ['./categoria-list.component.css']
})
export class CategoriaListComponent implements OnInit {
  categorias: any[] = [];

  constructor(private portalService: PortalService) {}

  ngOnInit(): void {
    this.portalService.listarCategorias().subscribe((data) => {
      this.categorias = data;
    });
  }
}