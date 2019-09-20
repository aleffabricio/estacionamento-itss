package com.br.estacionamentoitss.web.services;

import java.text.ParseException;
import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.estacionamentoitss.model.Estacionamento;
import com.br.estacionamentoitss.repository.EstacionamentoDao;

@RestController
public class EstacionamentoRest {

   @Autowired
   private EstacionamentoDao estacionamentoDAO;

   @RequestMapping(value = "/estacionamento", method = RequestMethod.POST)
   public Estacionamento salvar(@RequestBody Estacionamento estacionamento) throws ParseException {

      Date dtSaida = new Date();
      Date dtEntrada = new Date();
      estacionamento.setSaida(dtSaida);
      
      if (estacionamento.getSaida() != null) {
         long hora = Duration.between((Temporal) estacionamento.getEntrada().toInstant(), (Temporal) estacionamento.getSaida().toInstant()).toMinutes();
         estacionamento.setPermanencia(hora);

         if (hora <= 60) {
            estacionamento.setValorEstacionamento(estacionamento.getPatio().getTaxaHora());
         } else {
            estacionamento.setValorEstacionamento((hora * estacionamento.getPatio().getTaxaHora()) / 60);      
         }
         return estacionamentoDAO.save(estacionamento);
         
      } else {
         estacionamento.setEntrada(dtEntrada);
         return estacionamentoDAO.save(estacionamento);
      }
   }

   @RequestMapping(value = "/listar/veiculos", method = RequestMethod.GET)
   public List<Estacionamento> listar() {
      List<Estacionamento> estacionamentos = new ArrayList<>();
      estacionamentoDAO.findAll().forEach(estacionamentos::add);
      return estacionamentos;
   }

}
