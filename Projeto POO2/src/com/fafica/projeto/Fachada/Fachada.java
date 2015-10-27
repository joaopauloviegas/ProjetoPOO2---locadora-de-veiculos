package com.fafica.projeto.Fachada;

import java.util.ArrayList;

import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Carro.CarroJaCadastradoException;
import com.fafica.projeto.Carro.ControladorCarro;
import com.fafica.projeto.Cliente.CampoObrigatorioException;
import com.fafica.projeto.Cliente.ControladorCliente;
import com.fafica.projeto.Funcionario.ControladorFuncionario;
import com.fafica.projeto.Funcionario.Funcionario;

public class Fachada {

	public static Fachada instance;
	private ControladorCliente controladorCliente;
	private ControladorCarro controladorCarro;
	private ControladorFuncionario controladorFuncionario;
	
	public Fachada(){
		this.controladorCliente = new ControladorCliente();
		this.controladorCarro = new ControladorCarro();
		this.controladorFuncionario = new ControladorFuncionario();
	}// fim do construtor
	
	
	public static Fachada getInstance(){
		if(Fachada.instance == null){
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	
	//metodo cadastrar
	public void cadastar(Carro carro) throws IllegalArgumentException, 
											 CarroJaCadastradoException, 
											 CampoObrigatorioException{
		controladorCarro.cadastarCarro(carro);
		
	}
	
	public void cadastrar(Funcionario funcionario){
		this.controladorFuncionario.adicionar(funcionario);
	}
	
	
	//metodo atualizar
	public void atualizar(){
		
	}
	
	
	//metodo remover
	public void remover(){
		
	}
	
	
	//metodo procurar
	public Object procurar(){
		return null;
		
	}
	
	
	//metodo listar
	public ArrayList<Object> listar(){
		return null;
	}
	
	
}// fim da classe

