package com.fafica.projeto.Funcionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
		String query = "INSERT INTO funcionario8(NOME,CPF,ENDERECO)"
							+"VALUES ('"+funcionario.getNome()+"', '"+funcionario.getCpf()+"','"+funcionario.getEndereco()+"')";
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
		String query = "UPDATE FUNCIONARIO8	set NOME = '"+funcionario.getNome()+"',  CPF='"+funcionario.getCpf()+"', ENDERECO='"+funcionario.getEndereco()+"', WHERE CODIGO='" +funcionario.getId()+"'";
		conecta();
		try{
			stm = con.createStatement();
			stm.execute(query);
			stm.close();
		} catch (SQLException sql){
			System.out.println("Erro no atualizar" +sql);
		}
	}//fim do atualizar

	@Override
	public void remover(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionario listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionario buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	


}//fim da classe