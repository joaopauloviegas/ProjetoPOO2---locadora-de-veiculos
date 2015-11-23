package com.fafica.projeto.CadastroDeReserva;

import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Cliente.Cliente;
import com.fafica.projeto.Endereco.Endereco;


public class CadastroDeReserva {
	
	private int id;
	private String nomeCliente;
	private String nomeFuncionario;
	private String data;
	private String placa;
	private int quantidade;
	private int diascomCarro;
	private double valor;
	
	public CadastroDeReserva( String nomeCliente, String nomeFuncionario, String data, String placa,int quantidade, double valor){
		this.id = 0;
		this.nomeCliente = nomeCliente;
		this.nomeCliente = nomeCliente;
		this.data = data;
		this.placa = placa;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public CadastroDeReserva(){
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public int getDiascomCarro() {
		return diascomCarro;
	}

	public void setDiascomCarro(int diascomCarro) {
		this.diascomCarro = diascomCarro;
	}

	@Override
	public String toString() {
		return "CadastroDeReserva [id=" + id + ", nomeCliente=" + nomeCliente
				+ ", nomeFuncionario=" + nomeFuncionario + ", data=" + data
				+ ", placa=" + placa + ", quantidade=" + quantidade
				+ ", diascomCarro=" + diascomCarro + ", valor=" + valor + "]";
	}
	
	

}
