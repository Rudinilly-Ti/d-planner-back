package com.example.dplanner.api.dto;

public class SubjectDto {
  private String nome;
  private String professor;
  private Long semesterId;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getProfessor() {
    return professor;
  }

  public void setProfessor(String professor) {
    this.professor = professor;
  }

  public Long getSemesterId() {
    return semesterId;
  }

  public void setSemesterId(Long semesterId) {
    this.semesterId = semesterId;
  }

}
