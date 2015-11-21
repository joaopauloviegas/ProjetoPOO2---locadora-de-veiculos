package com.fafica.projeto.Fachada;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto.CadastroDeReserva.CadastroDeReserva;
import com.fafica.projeto.CadastroDeReserva.CadastroDeReservaJaCadastradaException;
import com.fafica.projeto.CadastroDeReserva.ControladorCadastroDeReserva;
import com.fafica.projeto.CadastroSaidaDeVeiculos.CadastroSaidaDeVeiculos;
import com.fafica.projeto.CadastroSaidaDeVeiculos.ControladorCadastroSaidaDeVeiculos;
import com.fafica.projeto.CadastroSaidaDeVeiculos.SaidaDeVeiculoNaoEncontradaException;
import com.fafica.projeto.CadastroSaidaDeVeiculos.SaidaDeVeiculosJaCadastradaException;
import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Carro.CarroJaCadastradoException;
import com.fafica.projeto.Carro.CarroNaoEncontradoException;
import com.fafica.projeto.Carro.ControladorCarro;
import com.fafica.projeto.Cliente.CPFInvalidoException;
import com.fafica.projeto.Cliente.CampoObrigatorioException;
import com.fafica.projeto.Cliente.Cliente;
import com.fafica.projeto.Cliente.ClienteJaCadastradoException;
import com.fafica.projeto.Cliente.ClienteNaoEncontradoException;
import com.fafica.projeto.Cliente.ControladorCliente;
import com.fafica.projeto.Endereco.ControladorEndereco;
import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Endereco.EnderecoJaCadastradoException;
import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;
import com.fafica.projeto.Funcionario.ControladorFuncionario;
import com.fafica.projeto.Funcionario.Funcionario;
import com.fafica.projeto.Funcionario.FuncionarioNaoEncontradoException;

public class Fachada {

	public static Fachada instance;
	private ControladorCliente controladorCliente;
	private ControladorCarro controladorCarro;
	private ControladorCadastroSaidaDeVeiculos controladorSaidaDeveiculos;
	private ControladorCadastroDeReserva controladorcadastrodeReserva;
	private ControladorFuncionario controladorFuncionario;
	private ControladorEndereco controladorEndereco;
	
	
	public Fachada(){
		this.controladorCliente = new ControladorCliente();
		this.controladorCarro = new ControladorCarro();
		this.controladorSaidaDeveiculos = new ControladorCadastroSaidaDeVeiculos();
		this.controladorFuncionario = new ControladorFuncionario();
		this.controladorcadastrodeReserva = new ControladorCadastroDeReserva();
		this.controladorEndereco = new ControladorEndereco();
		
	}// fim do construtor
	
	
	public static Fachada getInstance(){
		if(Fachada.instance == null){
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	
	
	//METODO CADASTRAR PARA CARRO
	public void cadastarCarro(Carro carro) throws IllegalArgumentException, CarroJaCadastradoException, CampoObrigatorioException, SQLException{
		System.out.println("Estou na fachada");
		controladorCarro.cadastarCarro(carro);
		
	}
	//METODO ATUAALIZAR PARA CARRO
	public void atualizarCarro(Carro carro) throws IllegalArgumentException, CarroNaoEncontradoException, CampoObrigatorioException{
		controladorCarro.atualizarCarro(carro);
	}
	//METODO REMOVER PARA CARRO
	public void removerCarro(String placa) throws IllegalArgumentException, CarroNaoEncontradoException, CampoObrigatorioException{
		controladorCarro.removerCarro(placa);
	}
	//METODO PROCURAR PARA CARRO
	public Carro procurarCarro(String placa) throws CarroNaoEncontradoException, CampoObrigatorioException{
		return controladorCarro.procurarCarro(placa);
	}
	//METODO LISTAR PARA CARRO
	public ArrayList<Carro> listarCarro() throws SQLException, CarroNaoEncontradoException{
		System.out.println("to na fachada");
		return controladorCarro.listarCarro();
		
	}
	
	
	    //METODO CADASTRAR PARA CLIENTE
		public void cadastarCliente(Cliente cliente) throws IllegalArgumentException, ClienteJaCadastradoException, CPFInvalidoException, CampoObrigatorioException, EnderecoJaCadastradoException, com.fafica.projeto.Endereco.CampoObrigatorioException, SQLException {
			controladorCliente.cadastarCliente(cliente);
		}
		//METODO ATUAALIZAR PARA CLIENTE
		public void atualizarCliente(Cliente cliente) throws ClienteNaoEncontradoException, CPFInvalidoException, CampoObrigatorioException{
			controladorCliente.atualizarCliente(cliente);
		}
		//METODO REMOVER PARA CLIENTE
		public void removerCliente(String cpf) throws ClienteNaoEncontradoException, CPFInvalidoException {
			controladorCliente.removerCliente(cpf);
		}
	
		//METODO PROCURAR PARA CLIENTE
		public Cliente procurarCliente(String cpf) throws ClienteNaoEncontradoException, CPFInvalidoException {
			return controladorCliente.procurarCliente(cpf);
		}
		//METODO LISTAR PARA CLIENTE
		public ArrayList<Cliente> listarCliente() throws SQLException{
			return this.controladorCliente.listarCliente();
		}
	
		
		//METODO CADASTRAR PARA CADASTRO SAIDA DE VEICULOS
		public void cadastarSaidaDeVeiculos(CadastroSaidaDeVeiculos saidaVeiculo) throws IllegalArgumentException, SaidaDeVeiculosJaCadastradaException, CampoObrigatorioException {
			controladorSaidaDeveiculos.cadastrarSaidaDeVeiculos(saidaVeiculo);
			System.out.println("fachada");
		}
		//METODO ATUAALIZAR PARA  CADASTRO SAIDA DE VEICULOS
		public void atualizarSaidaDeVeiculos(CadastroSaidaDeVeiculos saidaVeiculo) throws SaidaDeVeiculoNaoEncontradaException, CampoObrigatorioException {
			controladorSaidaDeveiculos.atualizarSaidaDeVeiculo(saidaVeiculo);
		}
		//METODO REMOVER PARA  CADASTRO SAIDA DE VEICULOS
		public void removerSaidaDeVeiculos(int id) {
			controladorSaidaDeveiculos.removerSaidaDeVeiculo(id);
		}
		//METODO PROCURAR PARA  CADASTRO SAIDA DE VEICULOS
		public CadastroSaidaDeVeiculos procurarSaidaDeVeiculos(String placa) {
			return controladorSaidaDeveiculos.procurarSaidaDeVeiculo(placa);
		}
		//METODO LISTAR PARA  CADASTRO SAIDA DE VEICULOS
		public ArrayList<CadastroSaidaDeVeiculos> listarSaidaDeVeiculo() throws SQLException, CarroNaoEncontradoException{
			return this.controladorSaidaDeveiculos.listarSaidaVeiculo();
		}
	
	
		//CADASTRO FUNCIONARIO
	    public void cadastrarFuncionario(Funcionario funcionario) throws EnderecoJaCadastradoException, com.fafica.projeto.Endereco.CampoObrigatorioException, IllegalArgumentException, CPFInvalidoException, SQLException{
		this.controladorFuncionario.adicionar(funcionario);
	    }
		
	    //ATUALIZAR DO FUNCIONARIO
	    public void atualizarFuncionario(Funcionario funcionario) throws EnderecoNaoEncontradoException, com.fafica.projeto.Endereco.CampoObrigatorioException, CPFInvalidoException{
		this.controladorFuncionario.atualizar(funcionario);
	    }//fim do atualizar
		
	    public void removerFuncionario(String cpf) throws EnderecoNaoEncontradoException, CPFInvalidoException, FuncionarioNaoEncontradoException{
		this.controladorFuncionario.remover(cpf);
		
	    }//fim do remover
	
	    public ArrayList<Funcionario> buscarFuncionario(String cpf){
		ArrayList<Funcionario> lista = null;
		lista = this.controladorFuncionario.buscar(cpf);
		return null;
	    }
	    
	    public ArrayList<Funcionario> listarFuncionario(){
	    	ArrayList<Funcionario> lista = null;
			lista = this.controladorFuncionario.listar();
			return lista;
	    }
	    
	    //CADASTRODERESERVA
	    public void cadastrarCadastroDeReserva(CadastroDeReserva cadastrodeReserva) throws CadastroDeReservaJaCadastradaException, com.fafica.projeto.CadastroDeReserva.CampoObrigatorioException{
	    	this.controladorcadastrodeReserva.adicionar(cadastrodeReserva);
	    }//fim do cadastrar
	    
	    //ATUALIZA CADASTRODERESERVA
	    public void atualizarCadastroDeReserva(CadastroDeReserva cadastrodeReserva){
	    	
	    }//fim do atualizar
	    
	    //REMOVE CADASTRODERESERVA
	    public void removerCadastroDeReserva(Integer id){
	    	
	    }//fim do remover 
	    
	    //PROCURAR CADASTRODERESERVA
	    public ArrayList<CadastroDeReserva> buscarCadastroDeReserva(Integer id){
			return null;
	    }//fim do PROCURACADASTRODERESERVA
	    
	    //LISTAR CADASTRODERESERVA
	    public ArrayList<CadastroDeReserva> listarCadastroDeReserva(){
	    	return null;
	    }
	    
	    //ENDERECO
	    public void cadastrarEndereco(Endereco endereco) throws EnderecoJaCadastradoException, com.fafica.projeto.Endereco.CampoObrigatorioException, SQLException{
	    	this.controladorEndereco.adicionar(endereco);
	    }//fim do cadastrar
	    
	    //ATUALIAR ENDERECO
	    public void atualizarEndereco(Endereco endereco) throws EnderecoNaoEncontradoException, com.fafica.projeto.Endereco.CampoObrigatorioException{
	    	this.controladorEndereco.atualizar(endereco);
	    }//fim do atualizar
	    
	    //REMOVER ENDERECO
	    public void removerEndereco(String cpf) throws EnderecoNaoEncontradoException{
	    	this.controladorEndereco.remover(cpf);
	    }//fim do remover
	    
	    //BUSCAR ENDERECO
	    public Endereco buscarEndereco(String cpf) throws EnderecoNaoEncontradoException{
	    	//ArrayList<Endereco> listar = new ArrayList<>();
	    	//listar = this.controladorEndereco.buscar(cpf);
	    	//return listar;
	    	return this.controladorEndereco.buscar(cpf);
	    }
	    
	    //LISTAR ENDERECO
	    public ArrayList<Endereco> listarEndereco(){
	    	ArrayList<Endereco> listar = new ArrayList<>();
	    	listar = this.controladorEndereco.listar();
	    	return listar;
	    }
	
}// fim da classe

