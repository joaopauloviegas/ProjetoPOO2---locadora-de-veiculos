package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.fafica.projeto.Cliente.Cliente;
import com.fafica.projeto.Funcionario.Funcionario;

public class RepositorioCadastroSaidaDeVeiculosBD implements IRpositorioCadastroSaidaDeVeiculos {

	//METODOS PARA FAZER CONEXAO E DESCONEXAO COM BANCO DE DADOS
	private Connection con = null;
	
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
	
	
	//METODO PARA CADASTRAR UMA NOVA SAIDA DE VEICULO	
	@Override
	public void cadastrarSaidaDeVeiculo(CadastroSaidaDeVeiculos saidaVeiculo) {
		String sql = "INSERT INTO saidaVeiculo (id,nomecliente,nomefuncionario,data,hora,valor,placa,combustivel) VALUES (?,?,?,?,?,?,?,?)" ;              
		conecta();
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setInt(1,saidaVeiculo.getId());
			stm.setString(2,saidaVeiculo.getNomeCliente());
			stm.setString(3, saidaVeiculo.getNomeFuncionario());
			stm.setString(4, saidaVeiculo.getData());
			stm.setString(5, saidaVeiculo.getHora());
			stm.setDouble(6, saidaVeiculo.getValor());
			stm.setString(7, saidaVeiculo.getPlaca());
			stm.setString(8, saidaVeiculo.getCombustivel());
			
			
			stm.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Saida cadastrada com sucesso!");
			System.out.println("repositorio");
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"ERRO AO CADASTRAR!"+e,"ERRO", JOptionPane.ERROR_MESSAGE);
		}
		desconecta();
		
	}
	//METODO PARA ATUALIZAR SAIDA DE VEICULO
	@Override
	public void atualizarSaidaDeVeiculo(CadastroSaidaDeVeiculos saidaVeiculo) {
		String sql = "update saidaveiculo set nomecliente=?,nomefuncionario=?,data=?,hora=?,valor=?,combustivel=? where placa=?" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			
			stm.setString(1, saidaVeiculo.getNomeCliente());
			stm.setString(2,saidaVeiculo.getNomeFuncionario());
			stm.setString(3, saidaVeiculo.getData());
			stm.setString(4, saidaVeiculo.getHora());
			stm.setDouble(5, saidaVeiculo.getValor());
			stm.setString(6, saidaVeiculo.getCombustivel());
			stm.setString(7, saidaVeiculo.getPlaca());
			stm.executeUpdate();
		
		}catch(SQLException e){
			System.out.println("Erro ao atualizar"+e);
		}
		desconecta();
		
	}// fim do metodo atualizar

	
	//METODO PARA REMOVER SAIDA DE VEICULO
	@Override
	public boolean removerSaidaDeVeiculo(int id) {
		String sql = "delete saidaveiculo where id=?" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setInt(1, id);
			
			stm.executeUpdate();
		
		}catch(SQLException e){
			System.out.println("Erro ao remover"+e);
		}
		
		
		desconecta();
		return true;
	}

	
	//METODO PARA PROCURAR SAIDA DE VEICULO
	@Override
	public CadastroSaidaDeVeiculos procurarSaidaDeVeiculo(String placa) {
		String sql = "select * from saidaveiculo where placa=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
	
			stm.setString(1, placa);
			
			ResultSet rs = stm.executeQuery();
			
			//ArrayList<CadastroSaidaDeVeiculos> procurar = new ArrayList<CadastroSaidaDeVeiculos>();
			
	       while(rs.next()){
	    	   
	    	   //id,nomecliente,nomefuncionario,data,hora,valor,placa,combustivel
	    	    int id = rs.getInt("id");
	    		String nomeCliente = rs.getString("nomeCliente");
	    		String nomeFuncionario = rs.getString("nomeFuncionario");
	    		String data = rs.getString("data");
	    		String hora = rs.getString("hora");
	    		String placa1 = rs.getString("placa");
	    		double valor = rs.getDouble("valor");
	    		String combustivel = rs.getString("combustivel");
	   
	    		CadastroSaidaDeVeiculos saidaVeiculo = new CadastroSaidaDeVeiculos(nomeCliente, nomeFuncionario, data, hora, placa1, valor, combustivel);
	    	   
	    	   return saidaVeiculo;
	
	       }
	       
	       stm.close();
	       rs.close();
	       
		}catch(Exception e){
			
		}
		desconecta();
		return null;
	}//fim do metodo procurar

	//METODO PARA LISTAR SAIDA DE VEICULO
	@Override
	public ArrayList<CadastroSaidaDeVeiculos> listarSaidaDeVeiculo() {
		// TODO Auto-generated method stub
		return null;
	}

}
