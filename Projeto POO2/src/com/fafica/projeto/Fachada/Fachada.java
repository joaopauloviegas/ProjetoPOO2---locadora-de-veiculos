package com.fafica.projeto.Fachada;

import java.util.ArrayList;

import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Carro.ControladorCarro;
import com.fafica.projeto.Cliente.ControladorCliente;

public class Fachada {

	public static Fachada instance;
	private ControladorCliente controladorCliente;
	private ControladorCarro controladorCarro;
	
	public Fachada(){
		this.controladorCliente = new ControladorCliente();
		this.controladorCarro = new ControladorCarro();
	}// fim do construtor
	
	
	public static Fachada getInstance(){
		if(Fachada.instance == null){
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	
	//metodo cadastrar
	public void cadastar(Carro carro){
		controladorCarro.cadastarCarro(carro);
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

