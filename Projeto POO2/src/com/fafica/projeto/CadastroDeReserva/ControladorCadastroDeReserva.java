package com.fafica.projeto.CadastroDeReserva;

import java.util.ArrayList;

import com.fafica.projeto.Cliente.ControladorCliente;
import com.fafica.projeto.Endereco.ControladorEndereco;
import com.fafica.projeto.Funcionario.ControladorFuncionario;

public class ControladorCadastroDeReserva {
	
	private IRepositorioCadastroDeReserva repositoriocadastrodeReserva;
	
	
	public ControladorCadastroDeReserva(){
		this.repositoriocadastrodeReserva = new RepositorioCadastroDeReservaBD();
		
	}
	
	public void adicionar(CadastroDeReserva cadastrodeReserva) throws CadastroDeReservaJaCadastradaException, CampoObrigatorioException {
		
		if(cadastrodeReserva == null) throw new IllegalArgumentException("Cadastro Inválido");
		if(cadastrodeReserva.getNomeCliente().equals("")) throw new CampoObrigatorioException();
		this.repositoriocadastrodeReserva.adicionar(cadastrodeReserva);
	}//fim do adicionar
	
	public void remover(double valor) throws CadastroDeReservaNaoEncontradoException{
		
		this.repositoriocadastrodeReserva.remover(valor);
	}//fim do adicionar

	public void atualizar(CadastroDeReserva cadastrodeReserva) throws CampoObrigatorioException, CadastroDeReservaNaoEncontradoException{
		if(cadastrodeReserva == null) throw new IllegalArgumentException("Cadastro Inválido");
		if(cadastrodeReserva.getNomeCliente().equals("")) throw new CampoObrigatorioException();
		
		this.repositoriocadastrodeReserva.atualizar(cadastrodeReserva);
	}//fim do adicionar
	
	public CadastroDeReserva procurar(double valor){
		return null;
	}//fim do procurar
	
	public ArrayList<CadastroDeReserva> listar(){
		return null;
	}//fim do listar

}
