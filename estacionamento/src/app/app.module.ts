import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClienteComponent } from './paginas/cliente/cliente.component';
import { PatioComponent } from './paginas/patio/patio.component';
import { LoginComponent } from './paginas/login/login.component';
import { RegistrarLoginComponent } from './paginas/registrar-login/registrar-login.component';
import { HomeComponent } from './paginas/home/home.component';
import { DashboardComponent } from './paginas/dashboard/dashboard.component';
import { MenuComponent } from './paginas/menu/menu.component';
import { VeiculoComponent } from './paginas/veiculo/veiculo.component';


@NgModule({
  declarations: [
    AppComponent,
    ClienteComponent,
    PatioComponent,
    LoginComponent,
    RegistrarLoginComponent,
    HomeComponent,
    DashboardComponent,
    MenuComponent,
    VeiculoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
