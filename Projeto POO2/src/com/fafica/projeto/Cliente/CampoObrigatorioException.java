package com.fafica.projeto.Cliente;

public class CampoObrigatorioException extends Exception{ 

	 public CampoObrigatorioException(String msg){
		 super("O campo " + msg + " é nulo ou invalido");
	 }
	 
	 public CampoObrigatorioException(){
		 super("Campo invalido");
	 }
}// fim da classe
