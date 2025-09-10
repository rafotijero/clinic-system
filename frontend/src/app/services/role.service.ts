import { inject, Injectable } from '@angular/core';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class RoleService {
  private userService = inject(UserService);

  isAssistant(): boolean {
    return this.userService.isAssistant();
  }
}
