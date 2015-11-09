package com.fafica.projeto.Cliente;

import com.fafica.projeto.Endereco.Endereco;

public class Cliente {


	private int id;
    private String nome;
    private String cpf;
    private String sexo;
    private String numeroTelefone;
    private Endereco endereco;
	
    public Cliente( String nome, String cpf, String sexo, String numeroTelefone, Endereco endereco) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.numeroTelefone = numeroTelefone;
		this.endereco = endereco;
	}// fim do construtor
    
    public Cliente(int id, String nome, String cpf, String sexo, String numeroTelefone, Endereco endereco) {
		
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.numeroTelefone = numeroTelefone;
		this.endereco = endereco;
	}// fim do construtor
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "codigo: " + id 
				+ "\nnome: " + nome 
				+ "\ncpf: " + cpf 
				+ "\nendereco: " + endereco 
				+ "\nsexo: "+ sexo 
				+ "\nnumeroTelefone: " + numeroTelefone;
	}
    
 
}// fim da classe
