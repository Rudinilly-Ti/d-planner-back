package com.example.dplanner.domain.entityes;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_semesters")
public class Semester {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Value("Semestre ${id}")
	private String nome;
	
    // @NotBlank(message = "Data de inicio não pode ser nula")
    private Date dataDeInicio;
    
    // @NotBlank(message = "Data de fim não pode ser nula")
    private Date dataDeFim;
    
		@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    
    
	public Semester() {

	}
	
	public Semester(Long id, String nome, Date dataDeInicio,Date dataDeFim, User user ) {
		 this.nome = nome;
	     this.dataDeInicio = dataDeInicio;
	     this.dataDeFim = dataDeFim;
	}

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

	public Date getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(Date dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public Date getDataDeFim() {
		return dataDeFim;
	}

	public void setDataDeFim(Date dataDeFim) {
		this.dataDeFim = dataDeFim;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDeFim, dataDeInicio, id, nome, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Semester other = (Semester) obj;
		return Objects.equals(dataDeFim, other.dataDeFim) && Objects.equals(dataDeInicio, other.dataDeInicio)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(user, other.user);
	}

	
	
}
