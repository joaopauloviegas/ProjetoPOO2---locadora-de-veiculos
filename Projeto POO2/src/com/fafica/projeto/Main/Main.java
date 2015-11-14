package com.fafica.projeto.Main;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, CarroJaCadastradoException, CampoObrigatorioException, EnderecoJaCadastradoException, com.fafica.projeto.Endereco.CampoObrigatorioException, EnderecoNaoEncontradoException, SQLException, CarroNaoEncontradoException, ClienteJaCadastradoException, CPFInvalidoException, ClienteNaoEncontradoException, SaidaDeVeiculosJaCadastradaException {
		 
		Fachada fachada = Fachada.getInstance();
		 
		int id = 5;
		 String nome = "POLO";
		 int ano = 2015;
		 String placa = "KKK-6789";
		 int quantidadePorta = 2;
		 double quilometragem = 7560;
		 String categoria = "popular";
		 //Carro carro = new Carro(id,nome,ano,placa,quantidadePorta,quilometragem,categoria);
		 //fachada.listarCarro();
		 String cpf = "264.975.198-31";
		 //fachada.listarCliente();
		 fachada.procurarCliente(cpf);
		 /*//fachada.cadastarCarro(carro);
		//fachada.atualizarCarro(carro);
		//fachada.removerCarro(carro);
		// fachada.procurarCarro(carro);
	    fachada.listarCarro();
		/*
		 /*
		//pegando a data e hora atual
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
		 
		 Endereco enderecoFuncionario = new Endereco("Pau Brasil","Centro","5 Andar","Recife");
		 Funcionario funcionario = new Funcionario("Gabriel Goncalves","123.123.32",enderecoFuncionario);
		 
		 
		 CadastroSaidaDeVeiculos saidaVeiculo = new CadastroSaidaDeVeiculos(1,cliente, funcionario, data1, hora1,carro,67890, 400.50);
		 fachada.cadastarSaidaDeVeiculos(saidaVeiculo);
		 
		*/ 
		
		//fachada.cadastarCliente(cliente);
		//fachada.atualizarCliente(cliente);
		//fachada.removerCliente(cliente);
		//fachada.procurarCliente(cliente);
		
		
		 
		 
		 
		 
		
		
		
		/*
		Endereco endereco = new Endereco("Pau Brasil","Centro","5 Andar","Recife");
		
		Funcionario funcionario = new Funcionario("Gabriel Goncalves","123.123.32",endereco);
		//fachada.cadastrar(funcionario);
		fachada.atualizarFuncionario(funcionario);
		*/
		//fachada.removerFuncionario(4);
		
		
		
		
		
		
		

	}//fim do main

}// fim da classe
