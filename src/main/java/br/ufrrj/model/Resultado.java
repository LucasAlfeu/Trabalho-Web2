package br.ufrrj.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discente")
public class Resultado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResultado;
	
	@Column(name = "nota")
	private float nota;
	
	@Column(name = "aprovado")
	private String status;
	
	@Column(name = "ID_Disciplina_ID_Disciplina")
	private int idDisciplina;
	
	@Column(name = "ID_Discente_ID_Discente")
	private int idDiscente;

	public int getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(int idResultado) {
		this.idResultado = idResultado;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public int getIdDiscente() {
		return idDiscente;
	}

	public void setIdDiscente(int idDiscente) {
		this.idDiscente = idDiscente;
	}
}
