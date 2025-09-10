import { Component, inject, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTable, MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatTooltipModule } from '@angular/material/tooltip';
import { RouterLink } from '@angular/router';
import { Paciente } from '../model/paciente.interface';
import { PacienteService } from '../services/paciente.service';
import { UiService } from '../services/ui.service';
import { RoleService } from '../services/role.service';
import { UserService } from '../services/user.service';

@Component({
    selector: 'app-inicio',
    imports: [MatIconModule, MatPaginatorModule, MatTableModule, MatIconModule, MatTooltipModule, MatButtonModule, RouterLink],
    templateUrl: './inicio.component.html',
    styleUrl: './inicio.component.css'
})
export default class InicioComponent implements OnInit{
  private pacienteService = inject(PacienteService);
  private uiService = inject(UiService);
  private roleService = inject(RoleService);
  private userService = inject(UserService);
  dataSource:any;
  displayedColumns: string[] = ['id', 'apellidoPaterno', 'apellidoMaterno', 'nombres', 'dni', 'peso', 'talla', 'imc', 'especialidad', 'acciones'];
  @ViewChild(MatPaginator, { static: true }) paginator!: MatPaginator;
  @ViewChild(MatTable,{static:true}) table!: MatTable<any>;
  userName: string = '';
  userRole: string = '';
  
  ngOnInit(): void {
    this.userName = this.userService.getName();
    this.userRole = this.userService.getRole();
    if(this.roleService.isAssistant()){
      this.displayedColumns = ['id', 'apellidoPaterno', 'apellidoMaterno', 'nombres', 'dni', 'peso', 'talla', 'imc', 'especialidad'];
    }
    this.listar();
  }

  listar(){
    this.pacienteService.listar().subscribe(
      (paciente)=>{
        this.dataSource = new MatTableDataSource<Paciente>(paciente)
        this.dataSource.paginator=this.paginator
      }
    )
  }

  eliminar(idPaciente: number): void {
    this.uiService.showConfirmationDialog().subscribe((result) => {
      if (result) {
        this.pacienteService.eliminar(idPaciente).subscribe(
          (paciente)=>{
            if(paciente!=undefined){
              this.listar();
              this.uiService.showSnackBar('Eliminado con éxito!');
            }
          }
        )
      }
    });
  }

  isNotAssistant(): boolean {
    return !this.userService.isAssistant();
  }

  isAdmin(): boolean {
    return this.userService.isAdmin();
  }
}
