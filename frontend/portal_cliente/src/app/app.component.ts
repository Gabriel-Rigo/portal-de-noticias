import { Component } from '@angular/core';
import { RouterOutlet, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { NoticiaListComponent } from './noticia-list/noticia-list.component'; // Certifique-se de que o caminho está correto
import { PortalService } from './services/portal.service';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterModule, CommonModule, NoticiaListComponent], // Coloque o NoticiaListComponent dentro do array imports
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'], // Corrija o typo (de "styleUrl" para "styleUrls")
})
export class AppComponent {
  title = 'portal-usuario';
  categorias: any[] = [];
  
  constructor(private portalService: PortalService) {}


  ngOnInit(): void {
    this.portalService.listarCategorias().subscribe((data) => {
      this.categorias = data;
    });
  }
}
