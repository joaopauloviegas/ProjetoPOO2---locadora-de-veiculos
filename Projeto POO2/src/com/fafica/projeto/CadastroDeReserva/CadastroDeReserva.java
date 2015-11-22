package com.fafica.projeto.CadastroDeReserva;

import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Cliente.Cliente;
import com.fafica.projeto.Endereco.Endereco;


public class CadastroDeReserva {
	
	private int id;
	private String nomeCliente;
	private String nomeFuncionario;
	private String data;
	private Carro carro;
	private int quantidade;
	private double valor;
	
	public CadastroDeReserva( String nomeCliente, String nomeFuncionario, String data, Carro carro, int quantidade, double valor){
		this.id = 0;
		this.nomeCliente = nomeCliente;
		this.nomeCliente = nomeCliente;
		this.data = data;
		this.carro = carro;
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
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
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
	
	@Override
	public String toString() {
		return "CadastroDeReserva [id=" + id + ", nomeCliente=" + nomeCliente
				+ ", nomeFuncionario=" + nomeFuncionario + ", data=" + data
				+ ", carro=" + carro + ", quantidade=" + quantidade
				+ ", valor=" + valor + "]";
	}

}
