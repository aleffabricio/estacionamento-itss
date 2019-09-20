package com.br.estacionamentoitss.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.estacionamentoitss.model.Estacionamento;

public interface EstacionamentoDao extends CrudRepository<Estacionamento, Long> {

}
