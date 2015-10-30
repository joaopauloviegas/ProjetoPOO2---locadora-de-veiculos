package com.fafica.projeto.Main;


import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Carro.CarroJaCadastradoException;
import com.fafica.projeto.Cliente.CampoObrigatorioException;
import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Endereco.EnderecoJaCadastradoException;
import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;
import com.fafica.projeto.Fachada.Fachada;
import com.fafica.projeto.Funcionario.Funcionario;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, CarroJaCadastradoException, CampoObrigatorioException, EnderecoJaCadastradoException, com.fafica.projeto.Endereco.CampoObrigatorioException, EnderecoNaoEncontradoException {
	
		Fachada fachada = Fachada.getInstance();
		
		Carro carro = new Carro("Siena",2010, "KJU-0908", 4, 64.700, "popular");
		fachada.cadastar(carro);
		
		Endereco endereco = new Endereco("Joaquim Nabuco","Kenndy","3 Andar","caruaru");
		
		Funcionario funcionario = new Funcionario("Joao Raflll","354.656",endereco);
		fachada.cadastrar(funcionario);
		fachada.atualizar(funcionario);
		
		
		
		
		
		
		

	}//fim do main

}// fim da classe
