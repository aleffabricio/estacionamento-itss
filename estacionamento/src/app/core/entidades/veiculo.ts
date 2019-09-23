import { Patio } from './patio';
import { Cliente } from './cliente';

export class Veiculo {
    public id: number;
    public placa: string;
    public modelo: string;
    public cor: string;
    public patio: Patio = new Patio();
    public cliente: Cliente = new Cliente();

    constructor() {}
}
