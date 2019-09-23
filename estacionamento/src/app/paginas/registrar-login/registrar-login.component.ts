import { Component, OnInit } from '@angular/core';

import { Usuario } from 'src/app/core/entidades/usuario';
import { AutenticarService } from 'src/app/core/services/login.service';

@Component({
  selector: 'app-registrar-login',
  templateUrl: './registrar-login.component.html',
  styleUrls: ['./registrar-login.component.scss']
})
export class RegistrarLoginComponent implements OnInit {

  usu: Usuario;

  constructor(private autenticarService: AutenticarService) {
    this.usu = new Usuario();
   }

  ngOnInit() {
  }

  public salvarUsuario() {     
    this.autenticarService.salvarUsuario(this.usu);
  }
}
