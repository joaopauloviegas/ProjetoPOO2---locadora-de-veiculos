package com.fafica.projeto.Endereco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RepositorioEnderecoBD implements IRepositorioEndereco{
	
	private Statement stm;
	private Connection con;
	
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

	@Override
	public void adicionar(Endereco endereco) throws EnderecoJaCadastradoException, SQLException {
		
		String query = "INSERT INTO ENDERECO(cpf,rua,numero,complemento,bairro,cidade,cep)" +
				"VALUES ('"+endereco.getCpf()+"', '"+endereco.getRua()+"' , '"+endereco.getNumero()+"', '"+endereco.getComplemento()+"', '"+endereco.getBairro()+"' , '"+endereco.getCidade()+"' , '"+endereco.getCep()+"')";
			
		conecta();
		try{
			stm = con.createStatement();
			stm.execute(query);
			stm.close();
		} catch(SQLException sql){
			System.out.println("Erro no inserir Endereco "+sql);
		}
		desconecta();
		
	}//fim do adicionar

	@Override
	public void atualizar(Endereco endereco) throws EnderecoNaoEncontradoException {
		String query = "UPDATE FUNCIONARIO SET rua=?,numero=?,complemento=?,bairro=?,cidade=?,cep=? WHERE endereco_id=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, endereco.getRua());
			stm.setString(2, endereco.getNumero());
			stm.setString(3, endereco.getComplemento());
			stm.setString(4, endereco.getBairro());
			stm.setString(5, endereco.getCidade());
			stm.setString(6, endereco.getCep());
			stm.setString(7, endereco.getBairro());
			stm.setInt(8, endereco.getId());
			stm.executeUpdate();
		} catch (SQLException sql){
			System.out.println("Erro no atualizar" +sql);
		}
		
	}//fim do atualiar

	@Override
	public Endereco buscar(Integer id) throws EnderecoNaoEncontradoException {
		
		return null;
	}

	@Override
	public void remover(Integer id) throws EnderecoNaoEncontradoException {
		String query = "DELETE FROM ENDERECO WHERE ENDERECO_ID=? ";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setInt(1, id);
			stm.executeUpdate();
		} catch (SQLException sql){
			System.out.println("Erro no atualizar" +sql);
		}
		
	}

	@Override
	public ArrayList<Endereco> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
