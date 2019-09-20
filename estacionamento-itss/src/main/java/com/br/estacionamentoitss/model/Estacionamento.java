package com.br.estacionamentoitss.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Estacionamento {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Temporal(TemporalType.TIMESTAMP)
   private Date entrada;
   @Temporal(TemporalType.TIMESTAMP)
   private Date saida;
   private long permanencia;
   private String placa;
   private double valorEstacionamento;
   @OneToOne
   @JoinColumn(nullable = false)
   private Patio patio;

   public Date getEntrada() {
      return entrada;
   }

   public void setEntrada(Date entrada) {
      this.entrada = entrada;
   }

   public Date getSaida() {
      return saida;
   }

   public void setSaida(Date saida) {
      this.saida = saida;
   }

   public String getPlaca() {
      return placa;
   }

   public void setPlaca(String placa) {
      this.placa = placa;
   }

   public Long getId() {
      return id;
   }

   public double getValorEstacionamento() {
      return valorEstacionamento;
   }

   public void setValorEstacionamento(double valorEstacionamento) {
      this.valorEstacionamento = valorEstacionamento;
   }

   public long getPermanencia() {
      return permanencia;
   }

   public void setPermanencia(long permanencia) {
      this.permanencia = permanencia;
   }

   public Patio getPatio() {
      return patio;
   }

   public void setPatio(Patio patio) {
      this.patio = patio;
   }

}
