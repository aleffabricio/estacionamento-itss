package com.br.estacionamentoitss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patio {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String descricao;
   private int quantidadeVaga;
   private double taxaHora;

   public Long getId() {
      return id;
   }

   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   public int getQuantidadeVaga() {
      return quantidadeVaga;
   }

   public void setQuantidadeVaga(int quantidadeVaga) {
      this.quantidadeVaga = quantidadeVaga;
   }

   public double getTaxaHora() {
      return taxaHora;
   }

   public void setTaxaHora(double taxa) {
      this.taxaHora = taxa;
   }

}
