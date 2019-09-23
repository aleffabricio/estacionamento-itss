import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { take } from 'rxjs/operators';

import { Constants } from './../util/constants';
import { Usuario } from '../entidades/usuario';

@Injectable({
  providedIn: 'root'
})
export class AutenticarService {
  
  autenticado: boolean = false;
  nomeUsuario: String = '';
  API: string = Constants.API;

  constructor(
    private http: HttpClient,
    private route: Router) { }

  public logInto(usuario) {
    return this.http.post(`${this.API}/login`, usuario).subscribe((resp: boolean) => {
      console.log(resp);
      this.autenticado = resp;
      if(this.autenticado == true){
        this.route.navigate(['/home']);
      }else{
        alert('Usuario ou senha invalida!');
      }
    });
  }

  public salvarUsuario(usuario) {
    return this.http.post(`${this.API}/salvar/usuario`, usuario).subscribe((resp: Usuario) => {
      this.nomeUsuario = resp.usuario; 
      this.route.navigate(['/login']);
    });
  }

  public logout(){
    this.autenticado = false;
    this.route.navigate(["/login"]);
  }
  
  public carregarToken() {
    this.autenticado == true ? true : false;
  }

  public isLogado() {
    return this.carregarToken();
  }


}
