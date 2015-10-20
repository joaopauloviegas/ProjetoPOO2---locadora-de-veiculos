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
	
	
	public void cadastar(Carro carro){
		controladorCarro.cadastarCarro(carro);
	}
	
	public void atualizar(){
		
	}
	
	public void remover(){
		
	}
	
	public Object procurar(){
		return null;
		
	}
	
	public ArrayList<Object> listar(){
		return null;
	}
	
	
}// fim da classe

