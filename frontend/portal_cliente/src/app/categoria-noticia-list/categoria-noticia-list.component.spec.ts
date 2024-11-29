import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoriaNoticiaListComponent } from './categoria-noticia-list.component';

describe('CategoriaNoticiaListComponent', () => {
  let component: CategoriaNoticiaListComponent;
  let fixture: ComponentFixture<CategoriaNoticiaListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CategoriaNoticiaListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CategoriaNoticiaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
