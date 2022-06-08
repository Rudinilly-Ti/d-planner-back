package com.example.dplanner.api.dto;

public class SubjectDto {
  private Long id;
  private String nome;
  private String professor;
  private Long semesterId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
