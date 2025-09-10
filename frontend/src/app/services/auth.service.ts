import { inject, Injectable } from '@angular/core';
import { RoleService } from './role.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private roleService = inject(RoleService);

  isAuth(): boolean {
    return !this.roleService.isAssistant();
  }
}
