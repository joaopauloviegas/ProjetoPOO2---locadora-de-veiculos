package com.fafica.projeto.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.fafica.projeto.Carro.Carro;
import com.fafica.projeto.Endereco.Endereco;

public class RepositorioClienteBD implements IRepositorioCliente {
	
	private Connection con = null;
	private int id = 0;
	
	public void conecta(){
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try{
			 con = DriverManager.getConnection(url,"system","joao123123");
			 
		}catch(SQLException sql){
			System.out.println("Erro na conexão" + sql);
		}//fim do catch
	}//fim do conecta
	
	public void desconecta(){
		try{
			con.close();
		}catch(SQLException sql){
			System.out.println("erro ao desconectar" +sql);
		}//fim do catch
	}//fim do desconecta
	
	
	
	//METODO CADASTRAR CLIENTE
	@Override
	public void cadastrarCliente(Cliente cliente) {
		
		
		String sql = "INSERT INTO cliente (NOME,CPF,SEXO,NUMEROTELEFONE) VALUES (?,?,?,?)" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCpf());
			stm.setString(3, cliente.getSexo());
			stm.setString(4, cliente.getNumeroTelefone());
						
			stm.executeUpdate();
			
			JOptionPane.showMessageDialog(null,"Clinte Cadastrado com sucesso!");
			
			
		}catch(SQLException e){
			//JOptionPane.showMessageDialog(null,"ERRO AO CADASTRAR"
				//	+ "\nVerifique se todos os dados estão escritos corretamente","ERRO", JOptionPane.ERROR_MESSAGE);
		}
		desconecta();
	}// fim do metodo cadastrar
	
	
	// METODO ATUALIZAR CLIENTE
	@Override
	public void atualizarCliente(Cliente cliente) {
		
		String sql = "update cliente set nome=?,cpf=?,sexo=?,numeroTelefone=? where cpf=?" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCpf());
			stm.setString(3, cliente.getSexo());
			stm.setString(4, cliente.getNumeroTelefone());
			stm.setString(5, cliente.getCpf());
			stm.executeUpdate();
			
		
		}catch(SQLException e){
			System.out.println("Erro ao atualizar"+e);
		}
		JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		desconecta();
		
	}// FIM DO METODO ATULIZAR CLIENTE
	
	
	//METODO REMOVER CLIENTE
	public boolean removerCliente(String cpf) {
		
		String sql = "delete cliente where cpf=?" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, cpf);
			stm.executeUpdate();
		
		}catch(SQLException e){
			//JOptionPane.showMessageDialog(null, "Erro ao remover!"+e,"ERRO", JOptionPane.ERROR_MESSAGE);
			
		}
		JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
		
		desconecta();
		
		return true;
	}// FIM FO METOTO REMOVER CLIENTE
		

	
		
		
	//METODO PROCURAR CLIENTE
	@Override
	public Cliente procurarCliente(String cpf) {
		String sql = "select * from cliente where cpf=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
	
			stm.setString(1, cpf);
			
			ResultSet rs = stm.executeQuery();
			
			
	       while(rs.next()){
	    	   
	    	   String nome = rs.getString("nome");
	    	   String cpf1 = rs.getString("cpf");
	    	   String sexo = rs.getString("sexo");
	    	   String numeroTelefone = rs.getString("numeroTelefone");
	    	   
	    	   //String bairro =rs.getString("bairro");
	    	   //String complemento = rs.getString("complemento");
	    	   //String cidade = rs.getString("cidade");
	    	   
	    	   Cliente cliente = new Cliente(nome, cpf1, sexo, numeroTelefone);
	    	   
	    	   System.out.println(cliente);   	  
	    	   
	    	   return cliente;
			
	       }
	       
	      
			stm.close();
			rs.close();
			
		}catch(SQLException e){
			System.out.println("Erro ao procurar"+e);
			
		}catch(Exception e){
			System.out.println(e);
		}
		desconecta();
		return null;
		
		
		
	}// FIM DO METODO PROCURAR CLIENTE

	
	// METOFO LISTAR CLIENTE
	@Override
	public ArrayList<Cliente> listarCliente() throws SQLException {
		//String sql = "select * from cliente";
		String sql = "SELECT cliente.nome, cliente.cpf, cliente.sexo, cliente.numerotelefone, endereco.rua, endereco.numero, endereco.complemento, endereco.bairro, endereco.cidade, endereco.cep  FROM   cliente, endereco WHERE cliente.cpf = endereco.cpf  ";
		conecta();
		PreparedStatement stm = con.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		try{

			
			while(rs.next()){
			
				//Cliente cliente = new Cliente(rs.getString("nome"),rs.getString("cpf"),rs.getString("sexo"),rs.getString("numerotelefone"));
				Cliente cliente = new Cliente(rs.getString("nome"),rs.getString("cpf"),rs.getString("sexo"),rs.getString("numerotelefone"));
				lista.add(cliente);
				
			
			}// fim do while
			System.out.println(lista);
			stm.close();
			rs.close();
			
			System.out.println("to aqui no repositorio");
		}catch(Exception e){
			
		}
		return lista;
	}// FIM DO METODO LISTAR CLIENTES



	
	
	
	
	
	
	
	
}// fim da classe
