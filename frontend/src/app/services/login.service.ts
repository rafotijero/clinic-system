import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { LoginInput, LoginOutput } from '../model/usuario.interface';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private http = inject(HttpClient);
  private api = inject(ApiService)

  login(credenciales: LoginInput) {
    return this.http.post<LoginOutput>(this.api.getApiUrl('auth/login'), credenciales);
  }
}
