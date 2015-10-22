package com.fafica.projeto.CadastroSaidaDeVeiculos;

public class SaidaDeVeiculoNaoEncontradaException extends Exception {

	public SaidaDeVeiculoNaoEncontradaException(String msg){
		super(msg);
	}
	
	public SaidaDeVeiculoNaoEncontradaException(){
		super("Saida de veiculo n�o encontrada!");
	}
	
}// fim da classe
