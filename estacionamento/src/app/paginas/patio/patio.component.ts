import { Component, OnInit } from '@angular/core';
import { Patio } from 'src/app/core/entidades/patio';
import { PatioService } from 'src/app/core/services/patio.service';

@Component({
  selector: 'app-patio',
  templateUrl: './patio.component.html',
  styleUrls: ['./patio.component.scss']
})
export class PatioComponent implements OnInit {
  patio: Patio;

  constructor(private patioService: PatioService) {
    this.patio = new Patio();
   }

  ngOnInit() {
  }

  public salvarPatio() {    
    this.patioService.salvarPatio(this.patio).subscribe((patio) => {
      this.patio = new Patio();
      alert('Patio salvo com sucesso!');
     });
  }

}
