import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DocumentoService {
 
  private apiUrl = 'http://localhost:8081/gdp/v1/api/documentos';

  constructor(private http: HttpClient) { }

  // Este método obtiene todos los documentos
  getDocumentos(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}