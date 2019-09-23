import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/core/entidades/cliente';
import { ClienteService } from 'src/app/core/services/cliente.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.scss']
})
export class ClienteComponent implements OnInit {

  cliente: Cliente;

  constructor(private clienteService: ClienteService) { 
    this.cliente = new Cliente();
  }

  ngOnInit() {
  }

  public salvarCliente() { 
    this.clienteService.salvarCliente(this.cliente).subscribe((cliente) => {
      this.cliente = new Cliente();
      alert('O cliente foi salvo com sucesso');
     });
  }

  public buscarClientes(){
   this.clienteService.buscarClientes();
  }

}
