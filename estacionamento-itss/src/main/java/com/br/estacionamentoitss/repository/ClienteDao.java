package com.br.estacionamentoitss.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.estacionamentoitss.model.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long> {

}
