package com.fafica.projeto.CadastroDeReserva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RepositorioCadastroDeReservaBD implements IRepositorioCadastroDeReserva {
	
	private Connection con;
	private Statement stm;
	
	public void conecta(){
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try{
			con = DriverManager.getConnection(url,"system","91737660");
		} catch (SQLException sql){
			JOptionPane.showMessageDialog(null, "Não conseguiu conectar com o Banco");
		}// fim do try
	}//fim do conecta
	
	public void desconecta(){
		try{
			con.close();
		} catch (SQLException sql){
			JOptionPane.showMessageDialog(null, "Não conseguiu desconectar");
		}//fim do catch
	}//fim do desconecta
	
	public void adicionar(CadastroDeReserva cadastrodeReserva){
		String query = "INSERT INTO CADASTRODERESERVA(CLIENTE,ENDERECO,DATA,CARRO,QUANTIDADE,VALOR)"
				+"VALUES ('"+cadastrodeReserva.getCliente().toString()+"', '"+cadastrodeReserva.getEndereco().toString()+"' , '"+cadastrodeReserva.getData()+"', '"+cadastrodeReserva.getCarro().toString()+"' , '"+cadastrodeReserva.getQuantidade()+"' , '"+cadastrodeReserva.getValor()+"')";
		conecta();
		try{
			stm = con.createStatement();
			stm.executeQuery(query);
			stm.close();
			
		} catch(SQLException sql){
			System.out.println("Erro no inserir"+sql);
		}//fim do try
		desconecta();
	}//fim do adicionar

	

	@Override
	public void atualizar(CadastroDeReserva cadastrodeReserva) {
		String query = "UPDATE CADASTRODERESERVA SET CLIENTE=?,ENDERECO=?,DATA=?, CARRO=?, QUANTIDADE=?, VALOR=? WHERE CODIGO=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, cadastrodeReserva.getCliente().toString());
			stm.setString(2, cadastrodeReserva.getEndereco().toString());
			stm.setString(3, cadastrodeReserva.getData());
			stm.setString(5, cadastrodeReserva.getCarro().toString());
			stm.setInt(6, cadastrodeReserva.getQuantidade());
			stm.setDouble(7, cadastrodeReserva.getValor());
			stm.setInt(8, cadastrodeReserva.getId());
			stm.executeUpdate();
		} catch (SQLException sql){
			System.out.println("Erro no atualizar" +sql);
		}
		
	}//fim do atualizar
	
	@Override
	public void remover(Integer id) {
		String query = "DELETE FROM CADASTRODERESERVA WHERE CODIGO=? ";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setInt(1, id);
			stm.executeUpdate();
		} catch (SQLException sql){
			System.out.println("Erro no atualizar" +sql);
		}
			
	}//fim do remover

	@Override
	public ArrayList<CadastroDeReserva> buscar(Integer id) {
		return null;
	}//fim do buscar

	@Override
	public ArrayList<CadastroDeReserva> listar() {
		return null;
	}//fim do listar

}
