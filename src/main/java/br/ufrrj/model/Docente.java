package br.ufrrj.model;

public class Docente {

	private int idDocente;
	private String usuario;
	private String senha;
	private String nome;
	private String identificacao;
	private boolean ehCoordenador;
	private boolean ehChefeDeDepartamento;
	
	public Docente() {
		
	}
	
	public Docente(String u, String s, String n, String i) {
		this.usuario = u;
		this.senha = s;
		this.nome = n;
		this.identificacao = i;
		this.ehCoordenador = false;
		this.ehChefeDeDepartamento = false;
	}
	
	public Docente(String u, String s, String n, String i, boolean coor, boolean chefe) {
		this.usuario = u;
		this.senha = s;
		this.nome = n;
		this.identificacao = i;
		this.ehCoordenador = coor;
		this.ehChefeDeDepartamento = chefe;
	}

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public boolean isEhCoordenador() {
		return ehCoordenador;
	}

	public void setEhCoordenador(boolean ehCoordenador) {
		this.ehCoordenador = ehCoordenador;
	}

	public boolean isEhChefeDeDepartamento() {
		return ehChefeDeDepartamento;
	}

	public void setEhChefeDeDepartamento(boolean ehChefeDeDepartamento) {
		this.ehChefeDeDepartamento = ehChefeDeDepartamento;
	}

}
