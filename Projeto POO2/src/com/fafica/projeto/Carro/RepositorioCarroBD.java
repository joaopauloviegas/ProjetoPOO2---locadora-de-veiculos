package com.fafica.projeto.Carro;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthScrollBarUI;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class RepositorioCarroBD implements IRepositorioCarro{

	
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
	
	
	
	//METODO PARA CADASTRAR CARRO
	@Override
	public void cadastrarCarro(Carro carro)throws SQLException {
	System.out.println("estou no repositorio BD");
		String sql = "INSERT INTO carro (NOME,ANO,PLACA,QUANTIDADEPORTA,QUILOMETRAGEM,CATEGORIA) VALUES (?,?,?,?,?,?)" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			
			stm.setString(1, carro.getNome());
			stm.setInt(2, carro.getAno());
			stm.setString(3, carro.getPlaca());
			stm.setInt(4, carro.getQuantidadePorta());
			stm.setDouble(5, carro.getQuilometragem());
			stm.setString(6, carro.getCategoria());
			
			stm.executeUpdate();
			
			
		}catch(SQLException e){
			System.out.println("Erro ao cadastrar"+e);
		}
		desconecta();
	    
	 
	}// FIM DO METODO CADASTRAR

	
	//METODO PARA ATUALIZAR CARRO
	@Override
	public void atualizarCarro(Carro carro) {
		
		String sql = "update carro set nome=?,ano=?,quantidadePorta=?,quilometragem=?,categoria=?,placa=? where placa=? " ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			
			stm.setString(1, carro.getNome());
			stm.setInt(2, carro.getAno());
			stm.setInt(3, carro.getQuantidadePorta());
			stm.setDouble(4, carro.getQuilometragem());
			stm.setString(5, carro.getCategoria());
			stm.setString(6, carro.getPlaca());
			stm.setString(7, carro.getPlaca());
			
			
			stm.executeUpdate();
		
		}catch(SQLException e){
			System.out.println("Erro ao atualizar"+e);
		}
		desconecta();
		
	}

	@Override
	public boolean removerCarro(String placa) {
		String sql = "delete carro where placa=?" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, placa);
			
			stm.executeUpdate();
		
		}catch(SQLException e){
			System.out.println("Erro ao remover"+e);
		}
		
		
		desconecta();
		
		return true;
	}// fim do metodo remover 
	
	
	
	///METODO PROCURAR CARRO
	@Override
	public Carro procurarCarro(String placa)throws CarroNaoEncontradoException {
		String sql = "select * from carro where placa=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, placa);
			
			ResultSet rs = stm.executeQuery();
			
			ArrayList<Carro> procurar= new ArrayList<Carro>();
			
			while(rs.next()){
				
				Carro carro = new Carro(rs.getInt("id"),
									rs.getString("nome"),
									rs.getInt("ano"),
									rs.getString("placa"),
									rs.getInt("quantidadePorta"),
									rs.getDouble("quilometragem"),
									rs.getString("categoria"));
				return carro;
				
			}
			
			stm.close();
			rs.close();
			
			/*JOptionPane.showMessageDialog(null, "\nID: "+carro.getId()+
												  "\nNOME: "+carro.getNome()+
												  "\nANO: "+carro.getAno()+
												  "\nPLACA: "+carro.getPlaca()+
												  "\nPORTAS: "+carro.getQuantidadePorta()+
												  "\nKM: "+carro.getQuilometragem()+
												  "\nCATEGORIA: " +carro.getCategoria());  */
												
			
		}catch(SQLException e){
			System.out.println("Erro ao procurar"+e);
			
		}catch(Exception e){
			System.out.println(e);
		}
		desconecta();
		return null;
		
		
	}// fim do metodo procurar

	

	
	
	
	@Override
	public ArrayList<Carro> listarCarro() throws SQLException, CarroNaoEncontradoException{
		
		String sql = "select * from carro";
		conecta();
		PreparedStatement stm = con.prepareStatement(sql);
	    ResultSet rs = stm.executeQuery();
	    
	    
	   ArrayList<Carro> lista = new ArrayList<Carro>();
		
		try{
											
							
			while(rs.next()){
				Carro carro = new Carro(rs.getInt("id"),
										rs.getString("nome"),
										rs.getInt("ano"),
										rs.getString("placa"), 
										rs.getInt("quantidadePorta"),
										rs.getDouble("quilometragem"),
										rs.getString("categoria"));
				
			lista.add(carro);
				
			}// fim do while
			for (Carro carro : lista) {
				System.out.println(carro);
			}
			 if (lista.isEmpty()) {
	               throw new CarroNaoEncontradoException();
	            } else {
	                return  lista;
	                
	            }
						 
			 
		}catch(SQLException e){
			System.out.println("Erro ao listar" + e);
		}
		return lista;
		

	}// fim do metodo

	
}// fim da classe
 