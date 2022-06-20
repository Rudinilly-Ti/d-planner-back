package com.example.dplanner.api.dto;

import java.util.Date;

public class CreateSemesterDto {
  private Long userId;
  private String nome;
  private Date dataDeInicio;
  private Date dataDeFim;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getNome() {
    return this.nome;
  }

  public void setEmail(String nome) {
    this.nome = nome;
  }

  public Date getDataInicio() {
    return this.dataDeInicio;
  }

  public void setDataInicio(Date dataDeInicio) {
    this.dataDeInicio = dataDeInicio;
  }

  public Date getDataFim() {
    return this.dataDeFim;
  }

  public void setDataFim(Date dataDeFim) {
    this.dataDeFim = dataDeFim;
  }
}
