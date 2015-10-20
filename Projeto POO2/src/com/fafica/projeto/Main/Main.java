package com.fafica.projeto.Main;


import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Fachada.Fachada;

public class Main {

	public static void main(String[] args) {
	
		Fachada fachada = Fachada.getInstance();
		
		Carro carro = new Carro("Siena",2010, "KJU-0908", 4, 64.700, "popular");
		fachada.cadastar(carro);
		
		

	}//fim do main

}// fim da classe
