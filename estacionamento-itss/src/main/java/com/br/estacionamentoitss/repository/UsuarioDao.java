package com.br.estacionamentoitss.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.estacionamentoitss.model.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

   public Usuario findByUsuario(String email);

}
