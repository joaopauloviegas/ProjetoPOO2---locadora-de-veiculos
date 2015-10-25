package com.fafica.projeto.CadastroSaidaDeVeiculos;

import com.fafica.projeto.Cliente.Cliente;

public class CadastroSaidaDeVeiculos {

	private int codigoLocacao;
	private Cliente cliente;
	private Funcionario funcionario;
	private String data;
	private double quilometragem;
	private double valor;
	
	
	public CadastroSaidaDeVeiculos(int codigoLocacao, Cliente cliente, String data, double quilometragem,double valor) {
		
		this.codigoLocacao = codigoLocacao;
		this.cliente = cliente;
		this.data = data;
		this.quilometragem = quilometragem;
		this.valor = valor;
	}
	
	
	public int getCodigoLocacao() {
		return codigoLocacao;
	}
	public void setCodigoLocacao(int codigoLocacao) {
		this.codigoLocacao = codigoLocacao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public double getQuilometragem() {
		return quilometragem;
	}
	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
    public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	@Override
	public String toString() {
		return "CadastroSaidaDeVeiculos "
				+ "\nCodigo Locacao: " + codigoLocacao 
				+ "\nCliente: " + cliente.getNome() 
				+ "\nData: " + data
				+ "\nQuilometragem: " + quilometragem 
				+ "\nValor: " + valor
				+"\nFuncionario: " + funcionario;
	}
	
	
	
	
}// fim da classe
