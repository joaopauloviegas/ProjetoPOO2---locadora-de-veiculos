package com.fafica.projeto.CadastroSaidaDeVeiculos;

import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Cliente.Cliente;
import com.fafica.projeto.Funcionario.Funcionario;

public class CadastroSaidaDeVeiculos {

	private int id;
	private Cliente cliente;
	private Funcionario funcionario;
	private String data;
	private String hora;
	private Carro carro;
	private double quilometragem;
	private double valor;
	
	
	public CadastroSaidaDeVeiculos(int id, Cliente cliente,Funcionario funcionario,String data,String hora,Carro carro, double quilometragem,double valor) {
		
		this.id = id;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.data = data;
		this.hora = hora;
		this.carro = carro;
		this.quilometragem = quilometragem;
		this.valor = valor;
	}
	
	public CadastroSaidaDeVeiculos(Cliente cliente,Funcionario funcionario, String data,String hora,Carro carro, double quilometragem,double valor) {
		
		
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.data = data;
		this.hora = hora;
		this.carro = carro;
		this.quilometragem = quilometragem;
		this.valor = valor;
	}
	
	
	public int getId() {
		return id;
	}
	public void setCodigoLocacao(int id) {
		this.id = id;
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
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
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
				+ "\nCodigo Locacao: " + id 
				+ "\nCliente: " + cliente.getNome() 
				+ "\nData: " + data
				+ "\nQuilometragem: " + quilometragem 
				+ "\nValor: " + valor
				+"\nFuncionario: " + funcionario;
	}
	
	
	
	
}// fim da classe
