import { Component, OnInit } from '@angular/core';
import { VeiculoService } from 'src/app/core/services/veiculo.service';

@Component({
  selector: 'app-estacionamento',
  templateUrl: './estacionamento.component.html',
  styleUrls: ['./estacionamento.component.scss']
})
export class EstacionamentoComponent implements OnInit {

  veiculos: any;
  

  constructor(private veiculoService: VeiculoService) { }

  ngOnInit() {
    this.listarVeiculos();
  }

  public listarVeiculos(){
    this.veiculoService.listarVeiculos().subscribe((veiculo) => {
      this.veiculos = veiculo;
      this.formatarValores(this.veiculos);
      console.log(this.veiculos);
      
     });
  }

  public formatarValores(veiculo){
    veiculo.forEach((veiculo,index) => {
      this.veiculos[index].entrada = (new Date(veiculo.entrada)).toLocaleString('pt-BR'); 
     if(veiculo.saida != null && !(veiculo.saida == '')){
      this.veiculos[index].saida = (new Date(veiculo.saida)).toLocaleString('pt-BR'); 
     }
      this.veiculos[index].valorEstacionamento = (veiculo.valorEstacionamento).toLocaleString('pt-BR'); 
    });
  }

}
