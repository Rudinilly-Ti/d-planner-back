package com.example.dplanner.domain.entityes;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "tb_activities")
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome da atividade não pode ser nula")
	private String nome;

	@NotNull(message = "Cadeira não pode ser nula")
	@ManyToOne
	@JoinColumn(name = "id_subject")
	private Subject subject;

	private String descricao;

	@NotNull(message = "Data de entrega não pode ser nula")
	private Date dataDeEntrega;

	@Value("1")
	private int type; // 1-ATIVIDADE ,2- APRESENTAÇÃO, 3-AVALIACAO;
	@Value("ABERTO")
	private String status; // ABERTO, ENTREGUE E PERDIDO

	public Activity() {
	}

	public Activity(Long id, String nome, Date dataDeEntrega, int type, String status, Subject subject) {
		this.nome = nome;
		this.dataDeEntrega = dataDeEntrega;
		this.type = type;
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataDeEntrega() {
		return dataDeEntrega;
	}

	public void setDataDeEntrega(Date dataDeEntrega) {
		Date date = new Date();
		this.dataDeEntrega = dataDeEntrega;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDeEntrega, descricao, id, nome, status, subject, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		return Objects.equals(dataDeEntrega, other.dataDeEntrega) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(status, other.status) && Objects.equals(subject, other.subject) && type == other.type;
	}

}