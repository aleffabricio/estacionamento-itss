import { Component, OnInit } from '@angular/core';
import { Veiculo } from 'src/app/core/entidades/veiculo';
import { VeiculoService } from 'src/app/core/services/veiculo.service';
import { ClienteService } from 'src/app/core/services/cliente.service';
import { PatioService } from 'src/app/core/services/patio.service';
import { Patio } from 'src/app/core/entidades/patio';
import { Cliente } from 'src/app/core/entidades/cliente';

@Component({
  selector: 'app-veiculo',
  templateUrl: './veiculo.component.html',
  styleUrls: ['./veiculo.component.scss']
})
export class VeiculoComponent implements OnInit {

  veiculo: Veiculo;
  clientes: Cliente;
  patios: Patio;

  constructor(private veiculoService: VeiculoService,
    private clienteService: ClienteService,
    private patioService: PatioService) {
      this.veiculo = new Veiculo();
     }

  ngOnInit() {
    this.listarPatios(); 
    this.buscarClientes();
  }

  public listarPatios() {    
    this.patioService.listarPatios().subscribe((patios: Patio) => { 
      this.patios = patios;
     });
  }

  public buscarClientes(){
    this.clienteService.buscarClientes().subscribe((clientes: Cliente) => {
      this.clientes = clientes;
    });
  } 

  public salvarVeiculo(){

    if(this.veiculo.patio != null 
      && this.veiculo.cliente != null 
      && this.veiculo.cor != null
      && this.veiculo.modelo != null
      && this.veiculo.placa != null){
        console.log(this.veiculo);
        this.veiculoService.salvarVeiculo(this.veiculo).subscribe((veiculo: Veiculo) => { 
          this.veiculo = new Veiculo;
          // this.veiculo = veiculo;
          alert('Veiculo salvo com sucesso');
         });
      }else{
        alert('Todos os campos são obrigatorios');
      }
   
  }
}
