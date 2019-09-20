package com.br.estacionamentoitss.web.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.estacionamentoitss.model.Cliente;
import com.br.estacionamentoitss.model.Estacionamento;
import com.br.estacionamentoitss.model.Veiculo;
import com.br.estacionamentoitss.repository.ClienteDao;
import com.br.estacionamentoitss.repository.EstacionamentoDao;
import com.br.estacionamentoitss.repository.VeiculoDao;

@RestController
public class VeiculoRest {

   @Autowired
   private VeiculoDao veiculoDAO;

   @Autowired
   private ClienteDao clienteDAO;

   @Autowired
   private EstacionamentoDao estacionamentoDAO;

   @RequestMapping(value = "/salvar/veiculo", method = RequestMethod.POST)
   public Veiculo salvar(@RequestBody Veiculo veiculo) throws Exception {

      salvarCliente(veiculo.getCliente());
      salvarEstacionamento(veiculo);

      return veiculoDAO.save(veiculo);
   }

   public Cliente salvarCliente(Cliente c) throws Exception {

      if (c.getCpf() != null) {
         return clienteDAO.save(c);
      }else {
    	  throw new Exception("CPF e obrigatorio para salvar.");
      }
   }

   public void salvarEstacionamento(Veiculo veiculo) {
      Estacionamento estacionamento = new Estacionamento();

      Date entrada = new Date();
      estacionamento.setEntrada(entrada);
      estacionamento.setPlaca(veiculo.getPlaca());
      estacionamento.setPatio(veiculo.getPatio());

      estacionamentoDAO.save(estacionamento);
   }

}
