import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExpedienteService {

  // La URL debe apuntar al nuevo endpoint
  private apiUrl = 'http://localhost:8081/gdp/v1/api/expedientes';

  constructor(private http: HttpClient) { }

  getExpedientes(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}