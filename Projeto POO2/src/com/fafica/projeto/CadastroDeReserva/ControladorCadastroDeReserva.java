package com.fafica.projeto.CadastroDeReserva;

import java.util.ArrayList;

import com.fafica.projeto.Cliente.CPFInvalidoException;
import com.fafica.projeto.Cliente.ControladorCliente;
import com.fafica.projeto.Endereco.ControladorEndereco;
import com.fafica.projeto.Funcionario.ControladorFuncionario;
import com.fafica.projeto.util.ValidarCPF;

public class ControladorCadastroDeReserva {
	
	private IRepositorioCadastroDeReserva repositoriocadastrodeReserva;
	
	
	public ControladorCadastroDeReserva(){
		this.repositoriocadastrodeReserva = new RepositorioCadastroDeReservaBD();
		
	}
	
	public void adicionar(CadastroDeReserva cadastrodeReserva) throws CadastroDeReservaJaCadastradaException, CampoObrigatorioException, CPFInvalidoException {
		
		if(cadastrodeReserva == null) throw new IllegalArgumentException("Cadastro Inválido");
		//if(cadastrodeReserva.getNomeCliente().equals("")) throw new CampoObrigatorioException();
		this.repositoriocadastrodeReserva.adicionar(cadastrodeReserva);
	}//fim do adicionar
	
	public void remover(String placa) throws CadastroDeReservaNaoEncontradoException{
		
		this.repositoriocadastrodeReserva.remover(placa);
	}//fim do adicionar

	public void atualizar(CadastroDeReserva cadastrodeReserva) throws CampoObrigatorioException, CadastroDeReservaNaoEncontradoException, CPFInvalidoException{
		if(cadastrodeReserva == null) throw new IllegalArgumentException("Cadastro Inválido");
		if(cadastrodeReserva.getNomeCliente().equals("")) throw new CampoObrigatorioException();
		this.repositoriocadastrodeReserva.atualizar(cadastrodeReserva);
	}//fim do adicionar
	
	public CadastroDeReserva procurar(String placa) throws CadastroDeReservaNaoEncontradoException{
		CadastroDeReserva temp;
		temp = repositoriocadastrodeReserva.buscar(placa);
		return this.repositoriocadastrodeReserva.buscar(placa);
	}//fim do procurar
	
	public ArrayList<CadastroDeReserva> listar(){
		ArrayList<CadastroDeReserva> listar = new ArrayList<>();
		listar = this.repositoriocadastrodeReserva.listar();
		return listar;
	}//fim do listar

}
