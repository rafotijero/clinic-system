import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Especialidad } from '../model/especialidad.interface';
import { Paciente } from '../model/paciente.interface';
import { EspecialidadService } from '../services/especialidad.service';
import { PacienteService } from '../services/paciente.service';
import { UiService } from '../services/ui.service';
import { ImcService } from '../services/imc.service';

@Component({
    selector: 'app-formulario-paciente',
    imports: [RouterLink, ReactiveFormsModule, MatInputModule, MatButtonModule, FormsModule, MatGridListModule, MatSelectModule, MatIconModule],
    templateUrl: './formulario-paciente.component.html',
    styleUrl: './formulario-paciente.component.css'
})
export default class FormularioPacienteComponent implements OnInit{
  private fb = inject(FormBuilder);
  private pacienteService = inject(PacienteService);
  private especialidadService = inject(EspecialidadService);
  private router = inject(Router);
  private route = inject(ActivatedRoute);
  private uiService = inject(UiService);
  private imcService = inject(ImcService);
  listaEspecialidades: Especialidad[]=[]
  form?: FormGroup;
  editarDatosPaciente?:Paciente;

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')  
    if(id!=null){
      this.pacienteService.obtener(parseInt(id)).subscribe(res =>{
        this. editarDatosPaciente = res;
        this.form = this.fb.group({
          apellidoPaterno:[res.apellidoPaterno,[Validators.required]],
          apellidoMaterno:[res.apellidoMaterno,[Validators.required]],
          nombres:[res.nombres,[Validators.required]],
          dni:[res.dni,[Validators.required]],
          peso:[res.peso,[Validators.required]],
          talla:[res.talla,[Validators.required]],
          imc:[res.imc,[Validators.required]],
          idEspecialidad: [res.especialidad.id,[Validators.required]]
        })
        }
      )
    }else{
      this.form = this.fb.group({
        apellidoPaterno:['',[Validators.required]],
        apellidoMaterno:['',[Validators.required]],
        nombres:['',[Validators.required]],
        dni:['',[Validators.required]],
        peso:['',[Validators.required]],
        talla:['',[Validators.required]],
        imc:[0,[Validators.required]],
        idEspecialidad: ['',[Validators.required]]
      })
    }
    
    this.especialidadService.listar().subscribe(
      (lista)=>{
        this.listaEspecialidades = lista
      }
    )
  }

  actualizarIMC(): void {
    let peso = parseFloat(this.form!.get('peso')?.value);
    let talla = parseFloat(this.form!.get('talla')?.value);
    let imc = this.imcService.calcularIMC(peso, talla);
    if(!isNaN(imc)){
      this.form!.get('imc')?.setValue(imc)
    }    
  }

  guardar(){
    if (this.form!.invalid) {
      return;
    }

    const pacienteFormulario = this.form!.value;
    if(this.editarDatosPaciente){
      let idPAciente = this.editarDatosPaciente.id;
      this.pacienteService.actualizar(idPAciente, pacienteFormulario)
      .subscribe(
        ()=>{
          this.router.navigate(['/inicio']);
          this.uiService.showSnackBar('Actualizado con éxito!');
        }
      )
    }else{
      this.pacienteService.registrar(pacienteFormulario)
      .subscribe(
        ()=>{
          this.router.navigate(['/inicio']);
          this.uiService.showSnackBar('Registrado con éxito!');
        }
      )
    }
  }
}
