import { Component, OnInit } from '@angular/core';
import { ExpedienteService } from '../services/expediente.service';

@Component({
  selector: 'app-lista-expedientes',
  templateUrl: './lista-expedientes.component.html',
  styleUrls: ['./lista-expedientes.component.css']
})
export class ListaExpedientesComponent implements OnInit {

  listaDeExpedientes: any[] = [];

  constructor(private expedienteService: ExpedienteService) { }

  ngOnInit(): void {
    this.expedienteService.getExpedientes().subscribe(data => {
      this.listaDeExpedientes = data;
      console.log('Datos de expedientes cargados!', this.listaDeExpedientes);
    });
  }
}