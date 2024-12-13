package br.ufrrj.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discente")
public class Discente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDiscente;
	@Column(name = "nome")
	private String nome;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "senha")
	private String senha;
	@Column(name = "matricula")
	private String matricula;
	@Column(name = "email")
	private String email;
	
	public Discente() {
		
	}
	
	public Discente(String n, String u, String s, String m, String e) {
		this.nome = n;
		this.usuario = u;
		this.senha = s;
		this.matricula = m;
		this.email = e;
	}
	
	
	public int getIdDiscente() {
		return idDiscente;
	}
	public void setIdDiscente(int idDiscente) {
		this.idDiscente = idDiscente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
