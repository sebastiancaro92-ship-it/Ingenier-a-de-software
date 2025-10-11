import { Component, OnInit } from '@angular/core';

import { DocumentoService } from '../services/documento.service';

@Component({
  selector: 'app-lista-documentos',
  templateUrl: './lista-documentos.component.html',
  styleUrls: ['./lista-documentos.component.css']
})
export class ListaDocumentosComponent implements OnInit {

  // Nombra la variable de forma clara.
  listaDeDocumentos: any[] = [];

  // Inyecta DocumentoService, no ExpedienteService.
  constructor(private documentoService: DocumentoService) { }

  ngOnInit(): void {
    this.documentoService.getDocumentos().subscribe(data => {
      this.listaDeDocumentos = data;
      console.log('Datos de documentos cargados!', this.listaDeDocumentos);
    });
  }
}