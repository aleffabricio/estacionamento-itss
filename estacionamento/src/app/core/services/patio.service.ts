import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { take } from 'rxjs/operators';

import { Constants } from '../util/constants';

@Injectable({
  providedIn: 'root'
})
export class PatioService {

  API: string = Constants.API;

  constructor(private http: HttpClient) { }

  public salvarPatio(patio) {
    console.log(patio);
    
    return this.http.post(`${this.API}/salvar/patio`, patio).pipe(take(1));
  }

  public listarPatios() {
    return this.http.get(`${this.API}/listar/patios`).pipe(take(1));
  }

  public listarVagas() {
    return this.http.get(`${this.API}/total/vagas`).pipe(take(1));
  }

  public excluirPatio(id) {
    return this.http.delete(`${this.API}/excluir/{id}`).pipe(take(1));
  }

}
