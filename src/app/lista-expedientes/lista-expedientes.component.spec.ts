import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaExpedientesComponent } from './lista-expedientes.component';

describe('ListaExpedientesComponent', () => {
  let component: ListaExpedientesComponent;
  let fixture: ComponentFixture<ListaExpedientesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListaExpedientesComponent]
    });
    fixture = TestBed.createComponent(ListaExpedientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
