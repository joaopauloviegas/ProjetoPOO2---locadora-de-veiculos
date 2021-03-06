package com.fafica.projeto.Carro;

public class Carro {

	private int id;
	private String nome;
	private int ano;
	private String placa;
	private int quantidadePorta;
	private double quilometragem;
	private String categoria;
	

	public Carro(String nome, int ano, String placa, int quantidadePorta, double quilometragem, String categoria) {
		this.id = 0;
		this.nome = nome;
		this.ano = ano;
		this.placa = placa;
		this.quantidadePorta = quantidadePorta;
		this.quilometragem = quilometragem;
		this.categoria = categoria;
	}
	
	public Carro(int id,String nome, int ano, String placa, int quantidadePorta, double quilometragem, String categoria) {
		this.setId(id);;
		this.nome = nome;
		this.ano = ano;
		this.placa = placa;
		this.quantidadePorta = quantidadePorta;
		this.quilometragem = quilometragem;
		this.categoria = categoria;
	}

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


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public int getQuantidadePorta() {
		return quantidadePorta;
	}


	public void setQuantidadePorta(int quantidadePorta) {
		this.quantidadePorta = quantidadePorta;
	}


	public double getQuilometragem() {
		return quilometragem;
	}


	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "Carro "
	            + "\nID: " + id
				+ "\nNome: " + nome 
				+ "\nAno: " + ano 
				+ "\nPlaca: " + placa 
				+ "\nQuantidadePorta: " + quantidadePorta
				+ "\nQuilometragem: " + quilometragem 
				+ "\nCategoria: " + categoria;
	}
	
	
	
}// fim da classe
