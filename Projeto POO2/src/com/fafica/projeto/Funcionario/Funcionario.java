package com.fafica.projeto.Funcionario;

import com.fafica.projeto.Endereco.Endereco;

public class Funcionario {
	
	private String nome;
	private String cpf;
	private Endereco endereco;
	private Integer id;
	
	
	public Funcionario(String nome,String cpf,Endereco endereco){
		this.id = 0;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}
	
	public Funcionario(Integer id, String nome, String cpf){
		this.setId(id);
		this.nome = nome;
		this.cpf = cpf;
		
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", id=" + id + "]";
	}
	
	

}
