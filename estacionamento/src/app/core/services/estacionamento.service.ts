import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { take } from 'rxjs/operators';

import { Constants } from './../util/constants';

@Injectable({
  providedIn: 'root'
})
export class EstacionamentoService {

  API: string = Constants.API;

  constructor(private http: HttpClient) { }

  public custoEstacionamento(parametro) {
    return this.http.post(`${this.API}/estacionamento`, parametro).pipe(take(1));
  }

  public buscarVagas() {
    return this.http.get(`${this.API}/estacionamento`).pipe(take(1));
  }
}
