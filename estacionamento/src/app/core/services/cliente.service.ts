import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { take } from 'rxjs/operators';

import { Constants } from '../util/constants';
import { Cliente } from '../entidades/cliente';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  API: string = Constants.API;
  cliente: Cliente;
 

  constructor(private http: HttpClient, private route: Router) {
    
  }

  
  public salvarCliente(cliente) {
      console.log(cliente);
      return this.http.post(`${this.API}/salvar/cliente`, cliente).pipe(take(1));
  }

  public buscarClientes() {
    return this.http.get(`${this.API}/listar/clientes`).pipe(take(1));
  }
}
