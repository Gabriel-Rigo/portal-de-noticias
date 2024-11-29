import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PortalService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  listarNoticias(): Observable<any> {
    return this.http.get(`${this.baseUrl}/noticia/listar`); 
  }

  // Listar categorias
  listarCategorias(): Observable<any> {
    return this.http.get(`${this.baseUrl}/categoria/listar`);
  }

  // Detalhar uma notícia
  obterNoticia(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/noticia/${id}`);
  }

  listarNoticiasPorCategoria(categoriaId: number): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:8080/noticia/categoria/${categoriaId}`);
  }
  
  obterCategoria(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/categoria/${id}`);
  }
}
