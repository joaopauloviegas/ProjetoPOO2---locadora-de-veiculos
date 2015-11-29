package com.fafica.projeto.Funcionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.fafica.projeto.Endereco.Endereco;

public class RepositorioFuncionarioBD implements IRepositorioFuncionario {
	
	private Statement stm = null;
	private Connection con = null;
	private int id = 1;	
	
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
	
	public void adicionar(Funcionario funcionario) throws FuncionarioJaCadastradoException{
		if(this.existe(funcionario.getCpf())) throw new FuncionarioJaCadastradoException();
		
		String query = "INSERT INTO funcionario1(NOME,CPF,SEXO,NUMEROTELEFONE)"
							+"VALUES ('"+funcionario.getNome()+"', '"+funcionario.getCpf()+"' , '"+funcionario.getSexo()+"', '"+funcionario.getNumeroTelefone()+"')";
		conecta();
			try{
				stm = con.createStatement();
				stm.execute(query);
				stm.close();
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			} catch(SQLException sql){
				System.out.println("Erro no inserir"+sql);
			}
			desconecta();
	}//fim do adicionar
	
	public void atualizar(Funcionario funcionario)throws FuncionarioNaoEncontradoException{
		if(this.existe(funcionario.getCpf()) == false) throw new FuncionarioNaoEncontradoException();
		String query = "UPDATE FUNCIONARIO1 SET NOME=?,Sexo=?,numeroTelefone=? WHERE CPF=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, funcionario.getNome());
			stm.setString(2, funcionario.getSexo());
			stm.setString(3, funcionario.getNumeroTelefone());
			stm.setString(4, funcionario.getCpf());
			stm.executeUpdate();
		} catch (SQLException sql){
			System.out.println("Erro no atualizar" +sql);
		}
	}//fim do atualizar

	@Override
	public void remover(String cpf)throws FuncionarioNaoEncontradoException {
		if(this.existe(cpf) == false) throw new FuncionarioNaoEncontradoException();
		String query = "DELETE FROM FUNCIONARIO1 WHERE CPF=? ";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, cpf);
			stm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Removido com sucesso!");
		} catch (SQLException sql){
			System.out.println("Erro no remover Funcionario" +sql);
		}
	}//fim do remover

	@Override
	public ArrayList<Funcionario> listar() {
		ArrayList<Funcionario> listar = new ArrayList<>();
		String query = "select * from FUNCIONARIO1";
		conecta();
		try{
		PreparedStatement stm = con.prepareStatement(query);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			   
	    	   Funcionario funcionario = new Funcionario(rs.getString("NOME"),rs.getString("CPF"),rs.getString("Sexo"),rs.getString("numeroTelefone"));
	    	   listar.add(funcionario);
	    	   
		}//fim do while
		for(Funcionario funcionario : listar){
			
		}
		} catch(SQLException sql){
			System.out.println("Erro no listar:" + sql);
		}//fim do catch
		desconecta();
		return listar;
	}//fim do listar

	@Override
	public Funcionario buscar(String cpf) throws FuncionarioNaoEncontradoException {
		if(this.existe(cpf) == false) throw new FuncionarioNaoEncontradoException();
		String query = "select nome,cpf,sexo,numeroTelefone from FUNCIONARIO1 where CPF=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, cpf);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				String nome = rs.getString("nome");
		    	   String cpf1 = rs.getString("cpf");
		    	   String sexo = rs.getString("sexo");
		    	   String numeroTelefone = rs.getString("numeroTelefone");
		    	   Funcionario funcionario = new Funcionario(nome,cpf1,sexo,numeroTelefone);
		    	   return funcionario;
		    	  // System.out.println(funcionario);
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
	
	public boolean existe(String cpf)  {
		boolean resposta = false;
		String query = "select nome,cpf,sexo,numeroTelefone from FUNCIONARIO1 where cpf=?";
		conecta();
		try{
		PreparedStatement stm = con.prepareStatement(query);
		stm.setString(1, cpf);
		ResultSet rs = stm.executeQuery();
		while(rs.next()){
			Funcionario funcionario = new Funcionario(rs.getString("nome"),rs.getString("cpf"),rs.getString("sexo"),rs.getString("numeroTelefone"));
			if(funcionario.getCpf().equals(cpf)) resposta = true;
			else resposta = false;
			
			return resposta;
		}
		
		
		} catch(SQLException sql){
			
		}
		return resposta;
		
	}
	
	
}//fim da classe