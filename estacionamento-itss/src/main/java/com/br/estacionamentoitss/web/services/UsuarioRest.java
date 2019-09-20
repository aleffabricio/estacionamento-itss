package com.br.estacionamentoitss.web.services;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.estacionamentoitss.model.Usuario;
import com.br.estacionamentoitss.repository.UsuarioDao;

@RestController
public class UsuarioRest {

   @Autowired
   private UsuarioDao usuarioDAO;

   @RequestMapping(value = "/novo/usuario", method = RequestMethod.POST)
   public Usuario salvar(@RequestBody Usuario usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException {

      String senha = usuario.getSenha();

      if (usuario.getUsuario() != null) {
         MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
         algorithm.update(senha.getBytes("UTF-8"));

         usuario.setSenha(new BigInteger(1, algorithm.digest()).toString(16));
      }
      return usuarioDAO.save(usuario);
   }

   @RequestMapping(value = "/login", method = RequestMethod.POST)
   public boolean login(@RequestBody Usuario usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException {

      String senha = usuario.getSenha();

      Usuario u = usuarioDAO.findByUsuario(usuario.getUsuario());

      MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
      algorithm.update(senha.getBytes("UTF-8"));

      senha = new BigInteger(1, algorithm.digest()).toString(16);

      return u.getUsuario() != null && u.getSenha().equals(senha) ? true : false;
   }

}
