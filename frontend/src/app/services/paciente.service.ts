import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Paciente } from '../model/paciente.interface';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {
  private http = inject(HttpClient);
  private apiService = inject(ApiService);

  listar(){
    return this.http.get<Paciente[]>(this.apiService.getApiUrl('paciente/listar'))
  }

  registrar(paciente: Paciente){
    return this.http.post(this.apiService.getApiUrl('paciente/registrar'), paciente)
  }

  obtener(id:number){
    return this.http.get<Paciente>(this.apiService.getApiUrl(`paciente/obtener/${id}`))
  }

  actualizar(id:number, paciente: Paciente){
    return this.http.put(this.apiService.getApiUrl(`paciente/actualizar/${id}`), paciente)
  }

  eliminar(id:number){
    return this.http.delete(this.apiService.getApiUrl(`paciente/eliminar/${id}`))
  }
}
