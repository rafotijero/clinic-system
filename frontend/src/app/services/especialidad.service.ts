import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Especialidad } from '../model/especialidad.interface';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class EspecialidadService {
  private http = inject(HttpClient);
  private api = inject(ApiService);

  listar(){
    return this.http.get<Especialidad[]>(this.api.getApiUrl('especialidad/listar'));
  }
}
