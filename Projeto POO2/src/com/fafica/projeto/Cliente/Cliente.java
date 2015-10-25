package com.fafica.projeto.Cliente;

import com.fafica.projeto.Endereco.Endereco;

public class Cliente {

	private String nome;
	private String cpf;
	private int codigo;
	private Endereco endereco;
	
	public Cliente(String nome, String cpf, int codigo){
		this.nome = nome;
		this.cpf = cpf;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", codigo=" + codigo + ", endereco=" + endereco + "]";
	}


	
	
	

		
}// fim da classe
