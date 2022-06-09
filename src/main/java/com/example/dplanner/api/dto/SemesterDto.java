package com.example.dplanner.api.dto;

import java.util.Date;
import com.example.dplanner.domain.entityes.User;

public class SemesterDto {
    private User user;
    private String nome;
    private Date dataDeInicio;
    private Date dataDeFim;
    
    public User getUser(){
        return this.user;
    }
    
    public void setUser(User user){
        this.user = user;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEmail(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio(){
        return this.dataDeInicio;
    }

    public void setDataInicio(Date dataDeInicio){
        this.dataDeInicio = dataDeInicio;
    }

    public Date getDataFim(){
        return this.dataDeFim;
    }

    public void setDataFim(Date dataDeFim){
        this.dataDeFim = dataDeFim;
    }
}
