package com.fafica.projeto.Cliente;

import com.fafica.projeto.Endereco.Endereco;

public class Cliente {


	private int codigo;
    private String nome;
    private String cpf;
    private Endereco endereco;
    private char sexo;
    private String numeroTelefone;
	
    public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
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
		return "codigo: " + codigo 
				+ "\nnome: " + nome 
				+ "\ncpf: " + cpf 
				+ "\nendereco: " + endereco 
				+ "\nsexo: "+ sexo 
				+ "\nnumeroTelefone: " + numeroTelefone;
	}
    
 
}// fim da classe
