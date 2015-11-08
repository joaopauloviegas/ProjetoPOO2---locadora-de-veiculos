package com.fafica.projeto.Carro;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;

//import com.mysql.jdbc.PreparedStatement;

public class RepositorioCarroBD implements IRepositorioCarro{

	//private PreparedStatement stm = null;
	private Connection con = null;
	private int id = 0;
	
	public void conecta(){
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try{
			 con = DriverManager.getConnection(url,"system","contabli123");
			 
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
	
	
	
	//METODO PARA CADASTRAR CARRO
	@Override
	public void cadastrarCarro(Carro carro)throws SQLException {
	System.out.println("estou no repositorio BD");
		String sql = "INSERT INTO carro (ID,NOME,ANO,PLACA,QUANTIDADEPORTA,QUILOMETRAGEM,CATEGORIA) VALUES (?,?,?,?,?,?,?)" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			
			stm.setString(2, carro.getNome());
			stm.setInt(3, carro.getAno());
			stm.setString(4, carro.getPlaca());
			stm.setInt(5, carro.getQuantidadePorta());
			stm.setDouble(6, carro.getQuilometragem());
			stm.setString(7, carro.getCategoria());
			
			stm.executeUpdate();
			ResultSet resultSet = null;
			Integer id = 0;
			 
			 while(resultSet.next()) {
		        	++id;
		        	stm.setInt(1, id);
			 }
			 System.out.println("ID do Insert no Banco " + id);
			
		}catch(SQLException e){
			System.out.println("Erro ao cadastrar"+e);
		}
		desconecta();
	    
	 
	}// FIM DO METODO CADASTRAR

	
	//METODO PARA ATUALIZAR CARRO
	@Override
	public void atualizarCarro(Carro carro) {
		System.out.println("estou no repositorio BD");
		String sql = "update carro set nome=?,ano=?,placa=?,quantidadedePorta=?,quilometragem=?,categoria=? where id=?" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			
			stm.setString(1, carro.getNome());
			stm.setInt(2, carro.getAno());
			stm.setString(3, carro.getPlaca());
			stm.setInt(4, carro.getQuantidadePorta());
			stm.setDouble(5, carro.getQuilometragem());
			stm.setString(6, carro.getCategoria());
			stm.setInt(7, carro.getId());
			
			stm.executeUpdate();
		
		}catch(SQLException e){
			System.out.println("Erro ao atualizar"+e);
		}
		desconecta();
		
	}

	@Override
	public boolean removerCarro(Carro carro) {
		String sql = "delete carro where id=?" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setInt(1, carro.getId());
			stm.executeUpdate();
		
		}catch(SQLException e){
			System.out.println("Erro ao remover"+e);
		}
		
		
		desconecta();
		
		return true;
	}// fim do metodo remover 
	
	
	
	///METODO PROCURAR CARRO
	@Override
	public Carro procurarCarro(Carro carro) {
		String sql = "select * from carro where id=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, carro.getId());
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				carro.toString();
			}
			stm.close();
			rs.close();
		
			
		}catch(SQLException e){
			System.out.println("Erro ao procurar"+e);
		}
		desconecta();
		return carro;
		
	}// fim do metodo procurar

	

	
	
	
	@Override
	public ArrayList<Carro> listarCarro() throws SQLException{
		  
		ArrayList<Carro> listaCarro = new ArrayList<Carro>();
		
		
		String sql = "select * from carro";
		conecta();
		PreparedStatement stm = con.prepareStatement(sql);
	    ResultSet rs = stm.executeQuery();
		
		try{
			
							
			while(rs.next()){
				Carro carro = new Carro(rs.getInt("id"),
										rs.getString("nome"),
										rs.getInt("ano"),
										rs.getString("placa"), 
										rs.getInt("quantidadePorta"),
										rs.getDouble("quilometragem"),
										rs.getString("categoria"));
				listaCarro.add(carro);
			}// fim do while
		
			for (Carro carro : listaCarro) {
				System.out.println(carro);
			}
			
		
		}catch(SQLException e){
			System.out.println("Erro ao listar" + e);
		}
		
		return listaCarro;
	}// fim do metodo

	
}// fim da classe
 