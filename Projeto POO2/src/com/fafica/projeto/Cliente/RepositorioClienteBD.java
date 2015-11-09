package com.fafica.projeto.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		
		System.out.println("estou no repositorio BD");
		String sql = "INSERT INTO cliente (ID,NOME,CPF,ENDERECO,SEXO,NUMEROTELEFONE) VALUES (?,?,?,?,?,?)" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setInt(1, cliente.getId());
			stm.setString(2, cliente.getNome());
			stm.setString(3, cliente.getCpf());
			stm.setString(4, cliente.getEndereco().toString());
			stm.setString(5, cliente.getSexo());
			stm.setString(6, cliente.getNumeroTelefone());
						
			stm.executeUpdate();
			
			System.out.println("Clinte Cadastrado com sucesso!");
			
			
		}catch(SQLException e){
			System.out.println("Erro ao cadastrar"+e);
		}
		desconecta();
	}// fim do metodo cadastrar
	
	
	// METODO ATUALIZAR CLIENTE
	@Override
	public void atualizarCliente(Cliente cliente) {
		
		String sql = "update cliente set nome=?,cpf=?,sexo=?,numeroTelefone=?,endereco=? where id=? or cpf=? or nome=?" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCpf());
			stm.setString(3, cliente.getSexo());
			stm.setString(4, cliente.getNumeroTelefone());
			stm.setString(5, cliente.getEndereco().toString());
			stm.setInt(6, cliente.getId());
			stm.setString(7, cliente.getCpf());
			stm.setString(8, cliente.getNome());
			stm.executeUpdate();
			
		
		}catch(SQLException e){
			System.out.println("Erro ao atualizar"+e);
		}
		JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		desconecta();
		
	}// FIM DO METODO ATULIZAR CLIENTE
	
	
	//METODO REMOVER CLIENTE
	public boolean removerCliente(Cliente cliente) {
		
		String sql = "delete cliente where id=? or cpf=?" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setInt(1, cliente.getId());
			stm.setString(2, cliente.getCpf());
			stm.executeUpdate();
		
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro ao remover!"+e,"ERRO", JOptionPane.ERROR_MESSAGE);
			
		}
		JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
		
		desconecta();
		
		return true;
	}// FIM FO METOTO REMOVER CLIENTE

	//METODO PROCURAR CLIENTE
	@Override
	public Cliente procurarCliente(Cliente cliente) {
		String sql = "select * from cliente where id=? or cpf=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, cliente.getId());
			stm.setString(2, cliente.getCpf());
			
			ResultSet rs = stm.executeQuery();
			ArrayList<Carro> lista= new ArrayList<Carro>();
			
			while(rs.next()){
				// estou com problema para passar o endereco. fiquei parado aqui
				Cliente c = new Cliente(rs.getInt("id"),
									rs.getString("nome"),
									rs.getString("cpf"),
									rs.getString("sexo"),
									rs.getString("numeroTelefone"),
									rs.getString("endereco");
									
				System.out.println(lista.add(c));
			}
			JOptionPane.showMessageDialog(null, lista);
			stm.close();
			rs.close();
		
			
		}catch(SQLException e){
			System.out.println("Erro ao procurar"+e);
			
		}catch(Exception e){
			System.out.println(e);
		}
		desconecta();
		return cliente;
	}// FIM DO METODO PROCURAR CLIENTE

	
	// METOFO LISTAR CLIENTE
	@Override
	public ArrayList<Cliente> listarCliente() {
		// TODO Auto-generated method stub
		return null;
	}// FIM DO METODO LISTAR CLIENTES

	
	
	
	
	
	
	
	
}// fim da classe
