import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { take } from 'rxjs/operators';

import { Constants } from './../util/constants';

@Injectable({
  providedIn: 'root'
})
export class VeiculoService {

  API: string = Constants.API;

  constructor(private http: HttpClient) { }

  public salvarVeiculo(veiculo) {
    return this.http.post(`${this.API}/salvar/veiculo`, veiculo).pipe(take(1));
  }
}
