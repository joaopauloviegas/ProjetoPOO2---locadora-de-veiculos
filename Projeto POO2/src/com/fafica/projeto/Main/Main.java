package com.fafica.projeto.Main;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.fafica.projeto.CadastroDeReserva.CadastroDeReserva;
import com.fafica.projeto.CadastroDeReserva.CadastroDeReservaJaCadastradaException;
import com.fafica.projeto.CadastroDeReserva.CadastroDeReservaNaoEncontradoException;
import com.fafica.projeto.CadastroSaidaDeVeiculos.CadastroSaidaDeVeiculos;
import com.fafica.projeto.CadastroSaidaDeVeiculos.SaidaDeVeiculosJaCadastradaException;
import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Carro.CarroJaCadastradoException;
import com.fafica.projeto.Carro.CarroNaoEncontradoException;
import com.fafica.projeto.Cliente.CPFInvalidoException;
import com.fafica.projeto.Cliente.CampoObrigatorioException;
import com.fafica.projeto.Cliente.Cliente;
import com.fafica.projeto.Cliente.ClienteJaCadastradoException;
import com.fafica.projeto.Cliente.ClienteNaoEncontradoException;
import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Endereco.EnderecoJaCadastradoException;
import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;
import com.fafica.projeto.Fachada.Fachada;
import com.fafica.projeto.Funcionario.Funcionario;
import com.fafica.projeto.Funcionario.FuncionarioNaoEncontradoException;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, CarroJaCadastradoException, CampoObrigatorioException, EnderecoJaCadastradoException, com.fafica.projeto.Endereco.CampoObrigatorioException, EnderecoNaoEncontradoException, SQLException, CarroNaoEncontradoException, ClienteJaCadastradoException, CPFInvalidoException, ClienteNaoEncontradoException, SaidaDeVeiculosJaCadastradaException, CadastroDeReservaJaCadastradaException, com.fafica.projeto.CadastroDeReserva.CampoObrigatorioException, FuncionarioNaoEncontradoException, CadastroDeReservaNaoEncontradoException {
		 
		Fachada fachada = Fachada.getInstance();
		 
		
		
		
		Cliente cliente = new Cliente("joao", "09948766458", "m", "99521-2279");
		//Endereco endereco = new Endereco("terra nova", "09948766458", "45","boa vista", "praça de areia", "caruaru","55038470");
		
		//fachada.cadastarCliente(cliente);
		//fachada.cadastrarEndereco(endereco);
		
		
	   	 //int id = 5;
		 //String nome = "POLO";
		 //int ano = 2015;
		 //String placa = "KKK-6789";
		 //int quantidadePorta = 2;
		 //double quilometragem = 7560;
		 //String categoria = "popular";
		 //Carro carro = new Carro(id,nome,ano,placa,quantidadePorta,quilometragem,categoria);
		 

//		fachada.listarCarro();

		//fachada.listarCarro();
//>>>>>>> branch 'master' of https://github.com/joaopauloviegas/ProjetoPOO2---locadora-de-veiculos.git
		
		 
		 
		 
		 
		 // String cpf = "264.975.198-31";
		 //fachada.listarCliente();
		 //fachada.procurarCliente(cpf);
		 /*//fachada.cadastarCarro(carro);
=======
		//int id = 5;
		 //String nome = "POLO";
		 //int ano = 2015;
		 //String placa = "KKK-6789";
		 //int quantidadePorta = 2;
		 //double quilometragem = 7560;
		 //String categoria = "popular";
		 //Carro carro = new Carro(id,nome,ano,placa,quantidadePorta,quilometragem,categoria);
		 //fachada.listarCarro();
		 ///fachada.cadastarCarro(carro);
>>>>>>> branch 'master' of https://github.com/joaopauloviegas/ProjetoPOO2---locadora-de-veiculos.git
		//fachada.atualizarCarro(carro);
		//fachada.removerCarro(carro);
		// fachada.procurarCarro(carro);
	    //fachada.listarCarro();
		
		
		/*pegando a data e hora atual
		 String data = "dd/MM/yyyy";  
		 String hora = "h:mm - a";  
		 String data1, hora1;  
		   
		 java.util.Date agora = new java.util.Date();;  
		 SimpleDateFormat formata = new SimpleDateFormat(data);  
		 data1 = formata.format(agora);  
		 formata = new SimpleDateFormat(hora);  
		 hora1 = formata.format(agora);  
		   
		// System.out.print("Data: "+data1 + "\nHora: "+hora1);  
		 
		 Endereco endereco = new Endereco("Guilherme Pinto","Derby","8 Andar","Recife");
		 Cliente cliente = new Cliente( 2,"Joao paulo","09948766458","masculino", "(81)99192-0532");
		 cliente.setEndereco(endereco);
		 */
		 
		 ///Endereco enderecoFuncionario = new Endereco("Pau Brasil","Centro","5 Andar","Recife");
		 //Funcionario funcionario = new Funcionario("Gabriel Goncalves","123.123.32",enderecoFuncionario);
		 //fachada.cadastrarFuncionario(funcionario);
		 //fachada.buscarFuncionario("123.123.32");
		 
		 //CadastroSaidaDeVeiculos saidaVeiculo = new CadastroSaidaDeVeiculos(1,cliente, funcionario, data1, hora1,carro,67890, 400.50);
		 //fachada.cadastarSaidaDeVeiculos(saidaVeiculo);
		 
	
		
		//fachada.cadastarCliente(cliente);
		//fachada.atualizarCliente(cliente);
		//fachada.removerCliente(cliente);
		//fachada.procurarCliente(cliente);
		
		
		 
		 
		 
		 
		
		
		
		
		Funcionario funcionario = new Funcionario("Bina Oliveira","5958005459","Masculino","371211212");
		//fachada.cadastrarFuncionario(funcionario);
		//fachada.removerFuncionario("5958005459");
		//fachada.buscarFuncionario("70711645418");
		//fachada.listarFuncionario();
		
		Endereco endereco = new Endereco("Travessa Pau","5958005459","254","1 Andar","Kennedy","Caruaru", "5507897987");
		//fachada.cadastrarEndereco(endereco);
		//fachada.atualizarEndereco(endereco);
		//fachada.buscarEndereco("5958005459");
		//fachada.listarEndereco();
		//fachada.removerEndereco("5958005459");
		CadastroDeReserva cadastrodeReserva = new CadastroDeReserva("Rayssa Leal","Gabriel ose","31122014","KKK-7879",1,5,600.00);
		//fachada.cadastrarCadastroDeReserva(cadastrodeReserva);
		//fachada.atualizarCadastroDeReserva(cadastrodeReserva);
		fachada.removerCadastroDeReserva("KKK-7879");
		//fachada.listarCadastroDeReserva();
		
		

	}//fim do main

}// fim da classe
