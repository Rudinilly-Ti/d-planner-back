package com.example.dplanner.domain.entityes;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
    //private Cadeira cadeira;
    private String descricao;
    
    @NotBlank(message = "Data de entrega não pode ser nula")
    private Date dataDeEntrega;
    
    @Value("1")
    private int type; //1-ATIVIDADE ,2- APRESENTAÇÃO, 3-AVALIACAO;
    @Value("ABERTO")
    private String status; //ABERTO, ENTREGUE E PERDIDO
    public Activity() {
    }

    public Activity(Long id, String nome, Date dataDeEntrega, int type, String status) {
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
		return Objects.hash(dataDeEntrega, descricao, id, nome, status, type);
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
				&& Objects.equals(status, other.status) && type == other.type;
	}
}
