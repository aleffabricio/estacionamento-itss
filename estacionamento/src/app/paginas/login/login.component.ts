import { Component, OnInit } from '@angular/core';

import { Usuario } from 'src/app/core/entidades/usuario';
import { AutenticarService } from 'src/app/core/services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  
  usu: Usuario;

  constructor(private autenticarService: AutenticarService) { 
    this.usu = new Usuario();
  }

  ngOnInit() {

  }

  public autenticar() { 
    this.autenticarService.logInto(this.usu);
  }

}
