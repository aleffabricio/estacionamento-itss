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

	  if(veiculo.getCliente().getCpf() != null) {
		  clienteDAO.save(veiculo.getCliente());
	  }else {
		  throw new Exception("CPF e necessario para salvar.");
	  }
	    
      Estacionamento estacionamento = new Estacionamento();

      Date dtEntrada = new Date();
      estacionamento.setEntrada(dtEntrada);
      estacionamento.setPlaca(veiculo.getPlaca());
      estacionamento.setPatio(veiculo.getPatio());
      estacionamentoDAO.save(estacionamento);

      return veiculoDAO.save(veiculo);
   }
}
