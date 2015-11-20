package com.fafica.projeto.Cliente;

import com.fafica.projeto.Endereco.Endereco;

public class Cliente {
	
    private String nome;
    private String cpf;
    private String sexo;
    private String numeroTelefone;
    private Endereco endereco;
    public Cliente( String nome, String cpf, String sexo, String numeroTelefone) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.numeroTelefone = numeroTelefone;
	}// fim do construtor
   

	public Cliente( ) {
			
    
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
		return  "\nnome: " + nome 
				+ "\ncpf: " + cpf 
				+ "\nsexo: "+ sexo 
				+ "\nnumeroTelefone: " + numeroTelefone;
	}
    
 
}// fim da classe
