package com.fafica.projeto.CadastroDeReserva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.fafica.projeto.Funcionario.Funcionario;

public class RepositorioCadastroDeReservaBD implements IRepositorioCadastroDeReserva {
	
	private Connection con;
	private Statement stm;
	
	public void conecta(){
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try{
			con = DriverManager.getConnection(url,"system","contabli123");
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
		String query = "INSERT INTO CADASTRODERESERVA(nome_cliente,nome_funcionario,data1,placa,quantidade,diascomCarro,VALOR) VALUES (?,?,?,?,?,?,?)";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, cadastrodeReserva.getNomeCliente());
			stm.setString(2, cadastrodeReserva.getNomeFuncionario());
			stm.setString(3, cadastrodeReserva.getData());
			stm.setString(4, cadastrodeReserva.getPlaca());
			stm.setInt(5, cadastrodeReserva.getQuantidade());
			stm.setInt(6, cadastrodeReserva.getDiascomCarro());
			stm.setDouble(7, cadastrodeReserva.getValor());
			stm.execute();
			stm.close();
			JOptionPane.showMessageDialog(null, "Cadastro de saida com sucesso");
		} catch(SQLException sql){
			System.out.println("Erro no inserir"+sql);
		}//fim do try
		desconecta();
	}//fim do adicionar

	

	@Override
	public void atualizar(CadastroDeReserva cadastrodeReserva) {
		String query = "UPDATE CADASTRODERESERVA SET nome_cliente=?,nome_funcionario=?,data1=?, quantidade=?,diascomCarro=?,valor=? WHERE placa=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, cadastrodeReserva.getNomeCliente());
			stm.setString(2, cadastrodeReserva.getNomeFuncionario());
			stm.setString(3, cadastrodeReserva.getData());
			stm.setInt(4, cadastrodeReserva.getQuantidade());
			stm.setInt(5, cadastrodeReserva.getDiascomCarro());
			stm.setDouble(6, cadastrodeReserva.getValor());
			stm.setString(7, cadastrodeReserva.getPlaca());
			stm.executeUpdate();
		} catch (SQLException sql){
			System.out.println("Erro no atualizar" +sql);
		}
		
	}//fim do atualizar
	
	@Override
	public void remover(String placa) {
		String query = "DELETE FROM CADASTRODERESERVA WHERE placa=? ";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, placa);
			stm.executeUpdate();
		} catch (SQLException sql){
			System.out.println("Erro no remover" +sql);
		}
			
	}//fim do remover

	@Override
	public CadastroDeReserva buscar(String placa) {
		String query = "select nome_cliente,nome_funcionario,data1,quantidade,diascomCarro,valor from CADASTRODERESERVA where placa=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, placa);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				String nomeCliente = rs.getString("nome_cliente");
		    	   String nomeFuncionario = rs.getString("nome_funcionario");
		    	   String data = rs.getString("data1");
		    	   int quantidade11 = rs.getInt("quantidade");
		    	   int DiasComCarro = rs.getInt("diascomcarro");
		    	   double valor = rs.getDouble("valor");
		    	   CadastroDeReserva cadastrodeReserva = new CadastroDeReserva(nomeCliente,
		    			   													   nomeFuncionario,
		    			   													   data,
		    			   													   quantidade11,
		    			   													   DiasComCarro,
		    			   													   valor);
		    	   return cadastrodeReserva;
		    	   //System.out.println(cadastrodeReserva);
			}//fim do while
			JOptionPane.showMessageDialog(null, "Busca efetuada com sucesso!");
			stm.close();
			rs.close();
		} catch (SQLException sql){
			JOptionPane.showConfirmDialog(null, "Erro no buscar"+sql);
		}//fim do try
		desconecta();
		return null;
	}//fim do buscar

	@Override
	public ArrayList<CadastroDeReserva> listar() {
		ArrayList<CadastroDeReserva> listar = new ArrayList<>();
		String query = "select * from CADASTRODERESERVA";
		conecta();
		try{
		PreparedStatement stm = con.prepareStatement(query);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			   
	    	   CadastroDeReserva cadastrodeReserva = new CadastroDeReserva(rs.getString("nome_cliente"),rs.getString("nome_funcionario"),rs.getString("data1"),rs.getString("placa"),rs.getInt("quantidade"),rs.getInt("diascomCarro"),rs.getDouble("valor"));
	    	   listar.add(cadastrodeReserva);
	    	   
		}//fim do while
		for(CadastroDeReserva cadastrodeReserva : listar){
			System.out.println(cadastrodeReserva);
		}
		} catch(SQLException sql){
			System.out.println("Erro no listar:" + sql);
		}//fim do catch
		desconecta();
		return listar;
		
	}//fim do listar

}
