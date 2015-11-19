package com.fafica.projeto.CadastroSaidaDeVeiculos;

import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Cliente.Cliente;
import com.fafica.projeto.Funcionario.Funcionario;

public class CadastroSaidaDeVeiculos {

	private int id;
	private String nomeCliente;
	private String nomeFuncionario;
	private String data;
	private String hora;
	private String placa;
	private double valor;
	private String combustivel;
	
	
	public CadastroSaidaDeVeiculos(int id, String nomeCliente,String nomeFuncionario,String data,String hora,String placa,double valor,String combustivel) {
		
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.nomeFuncionario = nomeFuncionario;
		this.data = data;
		this.hora = hora;
		this.placa = placa;
		this.valor = valor;
		this.combustivel = combustivel;
	}
	
	public CadastroSaidaDeVeiculos(String nomeCliente,String nomeFuncionario, String data,String hora,String placa,double valor,String combustivel) {
		
		
		this.nomeCliente = nomeCliente;
		this.nomeFuncionario = nomeFuncionario;
		this.data = data;
		this.hora = hora;
		this.placa = placa;
		this.valor = valor;
		this.combustivel = combustivel;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente= nomeCliente;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
    public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}


	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	@Override
	public String toString() {
		return "CadastroSaidaDeVeiculos "
				+ "\nID: " + id 
				+ "\nCliente: " + nomeCliente 
				+ "\nData: " + data
				+"\nHora: " + hora
				+"\nPlaca: " + placa
				+ "\nValor: " + valor
				+"\nFuncionario: " + nomeFuncionario
				+"\nCombustivel: "+ combustivel;
	}
	
	
	
	
}// fim da classe
