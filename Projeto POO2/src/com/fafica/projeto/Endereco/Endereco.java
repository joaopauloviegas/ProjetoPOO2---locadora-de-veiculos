package com.fafica.projeto.Endereco;

public class Endereco {
	
	private String rua;
	private String cpf;
	private String numero;	
	private String complemento;
	private String bairro;
	private Integer id;
	private String cidade;
	private String cep;
	
	public Endereco(String rua,String cpf,String bairro,String complemento,String cidade,String cep){
		this.id = 0;
		this.rua = rua;
		this.cpf = cpf;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
	}//fim do construtor
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Endereco(Integer id,String rua,String bairro,String complemento,String cidade){
	   this.setId(id);
	   this.rua = rua;
	   this.bairro = bairro;
	   this.complemento = complemento;
	   this.cidade = cidade;
	   
	}//fim do construtor2

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + " ,cpf=" +cpf+" ,numero=" + numero +  " , bairro=" + bairro + ", bairro=" + bairro + ", complemento="
				+ complemento + ", id=" + id + ", cidade=" + cidade + ", cep=" + cep +  "]";
	}
	
	
	

}
