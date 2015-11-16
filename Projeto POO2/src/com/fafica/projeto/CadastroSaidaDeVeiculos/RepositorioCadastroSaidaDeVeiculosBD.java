package com.fafica.projeto.CadastroSaidaDeVeiculos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		String sql = "INSERT INTO saidaveiculo (id,cliente,funcionario,data,hora,valor,carro) VALUES (?,?,?,?,?,?,?)" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setInt(1, saidaVeiculo.getId());
			stm.setString(2,saidaVeiculo.getCliente().toString());
			stm.setString(3, saidaVeiculo.getFuncionario().toString());
			stm.setString(4, saidaVeiculo.getData());
			stm.setString(5, saidaVeiculo.getHora());
			stm.setDouble(6, saidaVeiculo.getValor());
			stm.setString(7, saidaVeiculo.getCarro().toString());
			
			
			stm.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Saida cadastrada com sucesso!");
			
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"ERRO AO CADASTRAR!","ERRO", JOptionPane.ERROR_MESSAGE);
		}
		desconecta();
		
	}
	//METODO PARA ATUALIZAR SAIDA DE VEICULO
	@Override
	public void atualizarSaidaDeVeiculo(CadastroSaidaDeVeiculos saidaVeiculo) {
		String sql = "update saidaveiculo set nome=?,ano=?,quantidadePorta=?,quilometragem=?,categoria=? where placa=? or id=?" ;              
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			
			stm.setInt(1, saidaVeiculo.getId());
			stm.setString(2,saidaVeiculo.getCliente().toString());
			stm.setString(3, saidaVeiculo.getFuncionario().toString());
			stm.setString(4, saidaVeiculo.getData());
			stm.setString(5, saidaVeiculo.getHora());
			stm.setDouble(6, saidaVeiculo.getQuilometragem());
			stm.setDouble(7, saidaVeiculo.getValor());
			
			stm.executeUpdate();
		
		}catch(SQLException e){
			System.out.println("Erro ao atualizar"+e);
		}
		desconecta();
		
	}// fim do metodo atualizar

	
	//METODO PARA REMOVER SAIDA DE VEICULO
	@Override
	public boolean removerSaidaDeVeiculo(CadastroSaidaDeVeiculos codigoLocacao) {
		// TODO Auto-generated method stub
		return false;
	}

	
	//METODO PARA PROCURAR SAIDA DE VEICULO
	@Override
	public CadastroSaidaDeVeiculos procurarSaidaDeVeiculo(CadastroSaidaDeVeiculos codigoLocacao) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//METODO PARA LISTAR SAIDA DE VEICULO
	@Override
	public ArrayList<CadastroSaidaDeVeiculos> listarSaidaDeVeiculo() {
		// TODO Auto-generated method stub
		return null;
	}

}
