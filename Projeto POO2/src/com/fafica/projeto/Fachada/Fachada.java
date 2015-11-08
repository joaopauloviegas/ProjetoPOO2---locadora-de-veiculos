package com.fafica.projeto.Fachada;

import java.sql.SQLException;
import java.util.ArrayList;

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
import com.fafica.projeto.Endereco.EnderecoJaCadastradoException;
import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;
import com.fafica.projeto.Funcionario.ControladorFuncionario;
import com.fafica.projeto.Funcionario.Funcionario;

public class Fachada {

	public static Fachada instance;
	private ControladorCliente controladorCliente;
	private ControladorCarro controladorCarro;
	private ControladorCadastroSaidaDeVeiculos controladorSaidaDeveiculos;
	
	private ControladorFuncionario controladorFuncionario;
	
	
	public Fachada(){
		this.controladorCliente = new ControladorCliente();
		this.controladorCarro = new ControladorCarro();
		this.controladorSaidaDeveiculos = new ControladorCadastroSaidaDeVeiculos();
		this.controladorFuncionario = new ControladorFuncionario();
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
	public void removerCarro(Carro placa) throws IllegalArgumentException, CarroNaoEncontradoException, CampoObrigatorioException{
		controladorCarro.removerCarro(placa);
	}
	//METODO PROCURAR PARA CARRO
	public Object procurarCarro(Carro placa) throws CarroNaoEncontradoException, CampoObrigatorioException{
		return controladorCarro.procurarCarro(placa);
	}
	//METODO LISTAR PARA CARRO
	public ArrayList<Object> listarCarro(){
		return null;
	}
	
	
	    //METODO CADASTRAR PARA CLIENTE
		public void cadastar(Cliente cliente) throws IllegalArgumentException, ClienteJaCadastradoException, CPFInvalidoException, CampoObrigatorioException {
			controladorCliente.cadastarCliente(cliente);
		}
		//METODO ATUAALIZAR PARA CLIENTE
		public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException, CPFInvalidoException, CampoObrigatorioException{
			controladorCliente.atualizarCliente(cliente);
		}
		//METODO REMOVER PARA CLIENTE
		public void remover(String cpf) throws ClienteNaoEncontradoException, CPFInvalidoException {
			controladorCliente.removerCliente(cpf);
		}
		//METODO PROCURAR PARA CLIENTE
		public Object procurar(String cpf) throws ClienteNaoEncontradoException, CPFInvalidoException {
			return controladorCliente.procurarCliente(cpf);
		}
		//METODO LISTAR PARA CLIENTE
		public ArrayList<Cliente> listarCliente(){
			return null;
		}
	
		
		//METODO CADASTRAR PARA CADASTRO SAIDA DE VEICULOS
		public void cadastar(CadastroSaidaDeVeiculos saidaVeiculo) throws IllegalArgumentException, SaidaDeVeiculosJaCadastradaException, CampoObrigatorioException {
			controladorSaidaDeveiculos.cadastrarSaidaDeVeiculos(saidaVeiculo);
		}
		//METODO ATUAALIZAR PARA  CADASTRO SAIDA DE VEICULOS
		public void atualizar(CadastroSaidaDeVeiculos saidaVeiculo) throws SaidaDeVeiculoNaoEncontradaException, CampoObrigatorioException {
			controladorSaidaDeveiculos.atualizarSaidaDeVeiculo(saidaVeiculo);
		}
		//METODO REMOVER PARA  CADASTRO SAIDA DE VEICULOS
		public void remover(CadastroSaidaDeVeiculos codigoLocacao) {
			controladorSaidaDeveiculos.removerSaidaDeVeiculo(codigoLocacao);
		}
		//METODO PROCURAR PARA  CADASTRO SAIDA DE VEICULOS
		public Object procurar(CadastroSaidaDeVeiculos codigoLocacao) {
			return controladorSaidaDeveiculos.procurarSaidaDeVeiculo(codigoLocacao);
		}
		//METODO LISTAR PARA  CADASTRO SAIDA DE VEICULOS
		public ArrayList<Object> listar(){
			return null;
		}
	
	
		//CADASTRO FUNCIONARIO
	public void cadastrarFuncionario(Funcionario funcionario) throws EnderecoJaCadastradoException, com.fafica.projeto.Endereco.CampoObrigatorioException{
		this.controladorFuncionario.adicionar(funcionario);
	}
		//ATUALIZAR DO FUNCIONARIO
	public void atualizarFuncionario(Funcionario funcionario) throws EnderecoNaoEncontradoException, com.fafica.projeto.Endereco.CampoObrigatorioException{
		this.controladorFuncionario.atualizar(funcionario);
	}//fim do atualizar
		
	public void removerFuncionario(Integer id) throws EnderecoNaoEncontradoException{
		this.controladorFuncionario.remover(id);
		
	}//fim do remover
	
	public Funcionario buscar(Integer id){
		return null;
	}
	
}// fim da classe

