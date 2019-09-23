import { Component, OnInit } from '@angular/core';
import { PatioService } from 'src/app/core/services/patio.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  vg = {};
  constructor(private patioService: PatioService) { }

  ngOnInit() {
    this.patioService.listarVagas().subscribe((vagas) => {
      this.vg = vagas;
    });
  }

}
