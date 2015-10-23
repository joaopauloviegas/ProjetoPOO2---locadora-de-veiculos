package com.fafica.projeto.Endereco;

public class Endereco {
	
	private String rua;
	private String bairro;
	private String complemento;
	private Integer id;
	private String cidade;
	
	public Endereco(String rua,String bairro,String complemento,String cidade){
		this.id = 0;
		this.rua = rua;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
	}//fim do construtor
	
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
		return "Endereco [rua=" + rua + ", bairro=" + bairro + ", complemento="
				+ complemento + ", id=" + id + ", cidade=" + cidade + "]";
	}
	
	
	

}
