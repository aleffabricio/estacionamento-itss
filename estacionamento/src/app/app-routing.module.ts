import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './paginas/login/login.component';
import { RegistrarLoginComponent } from './paginas/registrar-login/registrar-login.component';
import { HomeComponent } from './paginas/home/home.component';
import { ClienteComponent } from './paginas/cliente/cliente.component';
import { PatioComponent } from './paginas/patio/patio.component';
import { VeiculoComponent } from './paginas/veiculo/veiculo.component';
import { EstacionamentoComponent } from './paginas/estacionamento/estacionamento.component';


const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'login/registrar', component: RegistrarLoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'cliente', component: ClienteComponent},
  {path: 'patio', component: PatioComponent},
  {path: 'veiculo', component: VeiculoComponent},
  {path: 'estacionamento', component: EstacionamentoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
