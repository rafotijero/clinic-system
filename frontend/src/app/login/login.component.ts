import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { LoginService } from '../services/login.service';
import { LoginOutput } from '../model/usuario.interface';
import { Router } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { UiService } from '../services/ui.service';

@Component({
    selector: 'app-login',
    imports: [
        MatCardModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        FormsModule,
        MatIconModule
    ],
    templateUrl: './login.component.html',
    styleUrl: './login.component.css'
})
export default class LoginComponent {
  credenciales = { usuario: '', clave: '' };
  private loginService = inject(LoginService);
  private router = inject(Router);
  private uiService = inject(UiService);

  onSubmit(){
    this.loginService.login(this.credenciales).subscribe({
      next:(response:LoginOutput)=>{
        if(response.success){
          sessionStorage.setItem("token", response.token);
          this.router.navigate(['/inicio']);
        }else{
          this.uiService.showSnackBar(response.respuesta);
        }
      },
      error:(err)=>{
        console.error('Login failed', err);
      }
    })
  }
}
