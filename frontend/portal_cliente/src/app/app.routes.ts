import { Routes } from '@angular/router';
import { NoticiaListComponent } from './noticia-list/noticia-list.component';
import { CategoriaListComponent } from './categoria-list/categoria-list.component';
import { NoticiaDetailComponent } from './noticia-detail/noticia-detail.component';
import { CategoriaNoticiaListComponent } from './categoria-noticia-list/categoria-noticia-list.component';

export const routes: Routes = [
  { path: 'noticias', component: NoticiaListComponent },
  { path: 'categorias', component: CategoriaListComponent },
  { path: 'categoria/:id/noticias', component: CategoriaNoticiaListComponent },
  { path: 'noticia/:id', component: NoticiaDetailComponent }, // Rota para detalhes
  { path: '', redirectTo: '/noticias', pathMatch: 'full' },  
   // Redirecionar para notícias
];
