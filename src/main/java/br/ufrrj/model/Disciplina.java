package br.ufrrj.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDisciplina;
	
	@Column(name= "nome")
	private String nomeDisciplina;
	
	@Column(name= "maxAlunos")
	private int maxAlunos;
	
	@Column(name= "numDiscMatriculados")
	private int numDiscentesMatriculados;
	
	@Column(name= "periodo")
	private String periodo;
	
	@Column(name= "cargaHoraria")
	private int cargaHoraria;
	
	@Column(name= "ID_Docente_ID_Docente")
	private int idDocente;

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getMaxAlunos() {
		return maxAlunos;
	}

	public void setMaxAlunos(int maxAlunos) {
		this.maxAlunos = maxAlunos;
	}

	public int getNumDiscentesMatriculados() {
		return numDiscentesMatriculados;
	}

	public void setNumDiscentesMatriculados(int numDiscentesMatriculados) {
		this.numDiscentesMatriculados = numDiscentesMatriculados;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
	
	

}
