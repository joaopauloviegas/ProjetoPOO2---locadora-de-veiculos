package com.fafica.projeto.CadastroDeReserva;

import java.util.ArrayList;

import com.fafica.projeto.Cliente.ControladorCliente;
import com.fafica.projeto.Endereco.ControladorEndereco;
import com.fafica.projeto.Funcionario.ControladorFuncionario;

public class ControladorCadastroDeReserva {
	
	private IRepositorioCadastroDeReserva repositoriocadastrodeReserva;
	private ControladorFuncionario controladorFuncionario;
	private ControladorEndereco controladorEndereco;
	private ControladorCliente controladorCliente;
	
	public ControladorCadastroDeReserva(){
		this.repositoriocadastrodeReserva = new RepositorioCadastroDeReservaBD();
		this.controladorCliente = new ControladorCliente();
		this.controladorEndereco = new ControladorEndereco();
		this.controladorFuncionario = new ControladorFuncionario();
	}
	
	public void adicionar(CadastroDeReserva cadastrodeReserva) throws CadastroDeReservaJaCadastradaException, CampoObrigatorioException {
		
		if(cadastrodeReserva == null) throw new IllegalArgumentException("Cadastro Inválido");
		if(cadastrodeReserva.getCliente().equals("")) throw new CampoObrigatorioException();
		this.repositoriocadastrodeReserva.adicionar(cadastrodeReserva);
	}//fim do adicionar
	
	public void remover(Integer id) throws CadastroDeReservaNaoEncontradoException{
		
		this.repositoriocadastrodeReserva.remover(id);
	}//fim do adicionar

	public void atualizar(CadastroDeReserva cadastrodeReserva) throws CampoObrigatorioException, CadastroDeReservaNaoEncontradoException{
		if(cadastrodeReserva == null) throw new IllegalArgumentException("Cadastro Inválido");
		if(cadastrodeReserva.getCliente().equals("")) throw new CampoObrigatorioException();
		
		this.repositoriocadastrodeReserva.atualizar(cadastrodeReserva);
	}//fim do adicionar
	
	public ArrayList<CadastroDeReserva> procurar(Integer id){
		return null;
	}//fim do procurar
	
	public ArrayList<CadastroDeReserva> listar(){
		return null;
	}//fim do listar

}
