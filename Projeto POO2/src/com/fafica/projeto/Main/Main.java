package com.fafica.projeto.Main;


import java.sql.SQLException;

import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Carro.CarroJaCadastradoException;
import com.fafica.projeto.Cliente.CampoObrigatorioException;
import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Endereco.EnderecoJaCadastradoException;
import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;
import com.fafica.projeto.Fachada.Fachada;
import com.fafica.projeto.Funcionario.Funcionario;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, CarroJaCadastradoException, CampoObrigatorioException, EnderecoJaCadastradoException, com.fafica.projeto.Endereco.CampoObrigatorioException, EnderecoNaoEncontradoException, SQLException {
		 
		Fachada fachada = Fachada.getInstance();
		 int id = 1;
		 String nome = "GOL";
		 int ano = 2010;
		 String placa = "kgi-2703";
		 int quantidadePorta = 4;
		 double quilometragem = 70000;
		 String categoria = "popular";
		 
		
		Carro carro1 = new Carro(nome,ano,placa,quantidadePorta,quilometragem,categoria);
		fachada.cadastarCarro(carro1);
		
		 
		//Endereco endereco = new Endereco("Joaquim Nabuco","Kenndy","3 Andar","caruaru");
		
		//Funcionario funcionario = new Funcionario("Joao Raflll","354.656",endereco);
		//fachada.cadastrar(funcionario);
		//fachada.atualizar(funcionario);
		
		
		
		
		
		
		

	}//fim do main

}// fim da classe
