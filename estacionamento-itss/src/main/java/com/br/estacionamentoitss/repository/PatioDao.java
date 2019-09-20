package com.br.estacionamentoitss.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.br.estacionamentoitss.model.Patio;

public interface PatioDao extends CrudRepository<Patio, Long> {
	
   @Query(value = "select count(*) as vagasOcupadas from Estacionamento where saida is null")
   public int findByTotalVagasOcupadas();
   
   @Query(value = "select sum(quantidadeVaga) from Patio")
   public int findByTotalVagas();
   
}
