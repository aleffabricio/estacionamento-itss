import { Component, OnInit } from '@angular/core';
import { VeiculoService } from 'src/app/core/services/veiculo.service';

@Component({
  selector: 'app-estacionamento',
  templateUrl: './estacionamento.component.html',
  styleUrls: ['./estacionamento.component.scss']
})
export class EstacionamentoComponent implements OnInit {

  veiculos: any;
  estacionamento: any;
  

  constructor(private veiculoService: VeiculoService) { }

  ngOnInit() {
    this.listarVeiculos();
  }

  public listarVeiculos(){
    this.veiculoService.listarVeiculos().subscribe((veiculo) => {
      this.veiculos = veiculo;
      console.log(this.veiculos);
      
     });
  }

  public salvarBaixaEstacionamento(estacionamento){
    console.log(JSON.stringify(estacionamento));
    this.veiculoService.salvarBaixaEstacionamento(estacionamento).subscribe((estacionamento) => {
      this.veiculos = estacionamento;
      console.log(this.estacionamento);
      alert('Registrado saida com sucesso!');
      this.listarVeiculos();
     });
  }

}
