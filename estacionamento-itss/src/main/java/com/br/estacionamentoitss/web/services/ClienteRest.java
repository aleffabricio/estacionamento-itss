package com.br.estacionamentoitss.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.estacionamentoitss.model.Cliente;
import com.br.estacionamentoitss.repository.ClienteDao;

@RestController
public class ClienteRest {
   
   @Autowired
   private ClienteDao clienteDAO;
   
   @RequestMapping(value = "/salvar/cliente", method = RequestMethod.POST)
   public Cliente salvar(@RequestBody Cliente cliente) {     
      return clienteDAO.save(cliente);
   }
   
   @RequestMapping(value = "/listar/clientes", method = RequestMethod.GET)
   public List<Cliente> listar() {
      List<Cliente> clientes = new ArrayList<>();
      clienteDAO.findAll().forEach(clientes::add);
      return clientes;
   }

}
