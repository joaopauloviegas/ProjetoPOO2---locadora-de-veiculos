package com.fafica.projeto.Main;


import java.sql.SQLException;

import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Carro.CarroJaCadastradoException;
import com.fafica.projeto.Carro.CarroNaoEncontradoException;
import com.fafica.projeto.Cliente.CampoObrigatorioException;
import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Endereco.EnderecoJaCadastradoException;
import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;
import com.fafica.projeto.Fachada.Fachada;
import com.fafica.projeto.Funcionario.Funcionario;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, CarroJaCadastradoException, CampoObrigatorioException, EnderecoJaCadastradoException, com.fafica.projeto.Endereco.CampoObrigatorioException, EnderecoNaoEncontradoException, SQLException, CarroNaoEncontradoException {
		 
		Fachada fachada = Fachada.getInstance();
		 //int id = 2;
		/* String nome = "POLO";
		 int ano = 2015;
		 String placa = "KKK-6789";
		 int quantidadePorta = 2;
		 double quilometragem = 7560;
		 String categoria = "popular";
		 Carro carro = new Carro(nome,ano,placa,quantidadePorta,quilometragem,categoria);
		//fachada.cadastarCarro(carro);
		//fachada.atualizarCarro(carro);
		//fachada.removerCarro(carro);
		fachada.procurarCarro(carro);
		//fachada.listarCarro();
		 */
		
		
		/*
		Endereco endereco = new Endereco("Pau Brasil","Centro","5 Andar","Recife");
		
		Funcionario funcionario = new Funcionario("Gabriel Goncalves","123.123.32",endereco);
		//fachada.cadastrar(funcionario);
		fachada.atualizarFuncionario(funcionario);
		*/
		//fachada.removerFuncionario(4);
		
		
		
		
		
		
		

	}//fim do main

}// fim da classe
