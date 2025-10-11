import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaDocumentosComponent } from './lista-documentos.component';

describe('ListaDocumentosComponent', () => {
  let component: ListaDocumentosComponent;
  let fixture: ComponentFixture<ListaDocumentosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListaDocumentosComponent]
    });
    fixture = TestBed.createComponent(ListaDocumentosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
