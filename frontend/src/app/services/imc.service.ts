import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImcService {

  constructor() { }

  calcularIMC(peso: number, talla: number): number {
    if (talla === 0) {
      return 0;
    }
    const imc = peso / Math.pow(talla, 2);
    return parseFloat(imc.toFixed(2));
  }
}
