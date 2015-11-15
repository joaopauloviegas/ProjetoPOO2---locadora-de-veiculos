package com.fafica.projeto.CadastroDeReserva;

import java.util.ArrayList;

public class ControladorCadastroDeReserva {
	
	private RepositorioCadastroDeReservaBD repositoriocadastrodeReserva;
	
	public void adicionar(CadastroDeReserva cadastrodeReserva) throws CadastroDeReservaJaCadastradaException {
		this.repositoriocadastrodeReserva.adicionar(cadastrodeReserva);
	}//fim do adicionar
	
	public void remover(Integer id){
		
	}//fim do adicionar

	public void atualizar(Integer id){
	
	}//fim do adicionar
	
	public ArrayList<CadastroDeReserva> procurar(Integer id){
		return null;
	}//fim do procurar
	
	public ArrayList<CadastroDeReserva> listar(){
		return null;
	}//fim do listar

}
