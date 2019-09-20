package com.br.estacionamentoitss.web.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.estacionamentoitss.model.Patio;
import com.br.estacionamentoitss.repository.PatioDao;

@RestController
public class PatioRest {

   @Autowired
   private PatioDao patioDAO;

   @RequestMapping(value = "/salvar/patio", method = RequestMethod.POST)
   public Patio salvar(@RequestBody Patio patio) throws Exception {
      
      if(patio.getDescricao() != null){
         return patioDAO.save(patio);
      }else {
    	  throw new Exception("Descrição não pode ser nula");
      }
   }

   @RequestMapping(value = "/total/vagas", method = RequestMethod.GET)
   public Map<String, Integer> listarVagas() {

      Map<String, Integer> map = new HashMap<>();
      
      int totalVagas = patioDAO.findByTotalVagas();
      int totalVagasOcupadas = patioDAO.findByTotalVagasOcupadas();
      int totalVagasLivres = totalVagas - totalVagasOcupadas;
      
      map.put("totalVagasOcupadas", totalVagasOcupadas);
      map.put("totalVagasLivres", totalVagasLivres);
      map.put("quantidadeVaga", totalVagas);

      return map;
   }
   
   @RequestMapping(value = "/listar/patios", method = RequestMethod.GET)
   public List<Patio> listar() {
      List<Patio> patios = new ArrayList<Patio>();
      patioDAO.findAll().forEach(patios::add);

      return patios;
   }
   
   @RequestMapping(value = "/excluir/patio/{id}", method = RequestMethod.DELETE)
   public void excluir(@PathVariable("id") Long id) {
      patioDAO.deleteById(id);
   }
}
