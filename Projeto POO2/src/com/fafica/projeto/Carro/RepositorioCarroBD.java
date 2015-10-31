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
	private int id = 1;
	
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
	
	
	
	//METODO PARA CADASTRAR CARRO
	@Override
	public void cadastrarCarro(Carro carro)throws SQLException {
	System.out.println("estou no repositorio BD");
		String sql = "INSERT INTO carro (ID,NOME,ANO,PLACA,QUANTIDADEPORTA,QUILOMETRAGEM,CATEGORIA) VALUES (?,?,?,?,?,?,?)" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			
			stm.setString(2, carro.getNome());
			stm.setInt(3, carro.getAno());
			stm.setString(4, carro.getPlaca());
			stm.setInt(5, carro.getQuantidadePorta());
			stm.setDouble(6, carro.getQuilometragem());
			stm.setString(7, carro.getCategoria());
			
			stm.execute();
			ResultSet resultSet = stm.getGeneratedKeys();
			Integer id = 0;
			 
			 while(resultSet.next()) {
		        	id = resultSet.getInt(1);
		        	stm.setInt(1, id);
			 }
			 System.out.println("ID do Insert no Banco " + id);
			
		}catch(SQLException e){
			System.out.println("Erro ao cadastrar"+e);
		}
		desconecta();
	    
	 
	}// FIM DO METODO CADASTRAR

	@Override
	public void atualizarCarro(Carro carro) {
		
		
	}

	@Override
	public boolean removerCarro(Carro placa) {
		
		return false;
	}// fim do metodo remover 
	@Override
	public Carro procurarCarro(Carro placa) {
		
		return null;
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
		
			return listaCarro;
		
		}catch(SQLException e){
			System.out.println("Erro ao listar" + e);
		}
		
		return listaCarro;
	}// fim do metodo

	
}// fim da classe
 