package com.fafica.projeto.Funcionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fafica.projeto.Endereco.Endereco;

public class RepositorioFuncionarioBD implements IRepositorioFuncionario {
	
	private Statement stm = null;
	private Connection con = null;
	private int id = 1;	
	
	public void conecta(){
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try{
			 con = DriverManager.getConnection(url,"system","91835759ga");
			 
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
	
	public void adicionar(Funcionario funcionario){
		String query = "INSERT INTO funcionario(NOME,CPF)"
							+"VALUES ('"+funcionario.getNome()+"', '"+funcionario.getCpf()+"')";
		conecta();
			try{
				stm = con.createStatement();
				stm.execute(query);
				stm.close();
			} catch(SQLException sql){
				System.out.println("Erro no inserir"+sql);
			}
			desconecta();
	}//fim do adicionar
	
	public void atualizar(Funcionario funcionario){
		String query = "UPDATE FUNCIONARIO SET NOME=?,CPF=? WHERE CPF=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, funcionario.getNome());
			stm.setString(2, funcionario.getCpf());
			stm.setString(3, funcionario.getCpf());
			stm.executeUpdate();
		} catch (SQLException sql){
			System.out.println("Erro no atualizar" +sql);
		}
	}//fim do atualizar

	@Override
	public void remover(Integer id) {
		String query = "DELETE FROM FUNCIONARIO WHERE CODIGO=? ";
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
	public ArrayList<Funcionario> listar() {
		return null;
	}//fim do listar

	@Override
	public ArrayList<Funcionario> buscar(String cpf) {
		ArrayList<Funcionario> lista = new ArrayList<>();
		String query = "select * from FUNCIONARIO where CPF=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, cpf);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				//Funcionario funcionario = new Funcionario(rs.getString("NOME"),rs.getString("CPF"), new Endereco(rs.getString("rua"),rs.getString("bairro"),rs.getString("complemento"),rs.getString("cidade")));
				//lista.add(funcionario);	
			}
			
			stm.close();
			rs.close();
		} catch (SQLException sql){
			System.out.println("Erro no Buscarr" +sql);
		}//fim do try
		desconecta();
		return lista;
	}//fim do buscar
	
	
	
}//fim da classe