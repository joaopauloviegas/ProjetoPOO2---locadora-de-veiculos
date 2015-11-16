package com.fafica.projeto.CadastroDeReserva;

import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Cliente.Cliente;
import com.fafica.projeto.Endereco.Endereco;


public class CadastroDeReserva {
	
	private int id;
	private Cliente cliente;
	private Endereco endereco;
	private String data;
	private Carro carro;
	private int quantidade;
	private double valor;
	
	public CadastroDeReserva(int id, Cliente cliente, Endereco endereco, String data, Carro carro, int quantidade, double valor){
		this.id = 0;
		this.cliente = cliente;
		this.endereco = endereco;
		this.data = data;
		this.carro = carro;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public CadastroDeReserva( Cliente cliente, Endereco endereco, String data, Carro carro, int quantidade, double valor){
		this.setId(id);
		this.cliente = cliente;
		this.endereco = endereco;
		this.data = data;
		this.carro = carro;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	@Override
	public String toString() {
		return "CadastroDeReserva [id=" + id + ", cliente=" + cliente
				+ ", endereco=" + endereco + ", data=" + data + ", carro="
				+ carro + ", quantidade=" + quantidade + ", valor=" + valor
				+ "]";
	}
	
	
	
	
	
	
	

}
