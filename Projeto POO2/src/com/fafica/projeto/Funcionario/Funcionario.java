package com.fafica.projeto.Funcionario;

import com.fafica.projeto.Endereco.Endereco;

public class Funcionario {
	
	private String login;
	private String password;
	private String nome;
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	private String cpf;
	private String sexo;
	private String numeroTelefone;
	private Integer id;
	
	
	public Funcionario(String nome,String cpf,String sexo,String numeroTelefone){
		this.id = 0;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.numeroTelefone = numeroTelefone;
		
	}
	

	public Funcionario(String nome, String sexo,String numeroTelefone){
		this.setId(id);
		this.nome = nome;
		this.sexo = sexo;
		this.numeroTelefone = numeroTelefone;
		
	}
	
	public Funcionario(){
		
	}
	

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", Cpf=" + cpf + " , Sexo=" + sexo + " , numeroTelefone=" +numeroTelefone+ "]";
	}
	
	

}
