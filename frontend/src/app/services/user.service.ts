import { Injectable, inject } from '@angular/core';
import { JwtDecoderService } from './jwt-decoder.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private jwtDecoder = inject(JwtDecoderService);
  private decodedToken: any;

  constructor() {
    this.decodedToken = this.jwtDecoder.decodeToken();
  }

  getRole(): string {
    return this.decodedToken ? this.decodedToken.role : '';
  }

  getName(): string {
    return this.decodedToken ? this.decodedToken.sub : '';
  }

  isAssistant(): boolean {
    return this.getRole() === 'ASISTENTE';
  }

  isAdmin(): boolean {
    return this.getRole() === 'ADMIN';
  }
}
