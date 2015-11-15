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
	private PreparedStatement stm;
	
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
		String query = "INSERT INTO CADASTRODESERVA(CLIENTE,ENDERECO,DATA,CARRO,QUANTIDADE,VALOR)"
				+"VALUES ('"+cadastrodeReserva.getCliente()+"', '"+cadastrodeReserva.getEndereco()+"' , '"+cadastrodeReserva.getData()+"', '"+cadastrodeReserva.getCarro()+"' , '"+cadastrodeReserva.getQuantidade()+"' , '"+cadastrodeReserva.getValor()+"')";
		conecta();
		try{
			stm = con.prepareStatement(query, new String[]{"CODIGO"});
			ResultSet rs = stm.getGeneratedKeys();
			Integer id = 0;
			
			while(rs.next()){
				id = rs.getInt(1);
			}//fim do while
			System.out.println("Id do insert no banco" +id);
			stm.close();
			rs.close();
		} catch(SQLException sql){
			System.out.println("Erro no inserir"+sql);
		}//fim do try
		desconecta();
		
		
	}//

	@Override
	public void remover(CadastroDeReserva cadastrodeReserva) {
			
		
	}

	@Override
	public void atualizar(CadastroDeReserva cadastrodeReserva) {
		
	}

	@Override
	public ArrayList<CadastroDeReserva> buscar(Integer id) {
		
		return null;
	}

	@Override
	public ArrayList<CadastroDeReserva> listar() {
		
		return null;
	}

}
