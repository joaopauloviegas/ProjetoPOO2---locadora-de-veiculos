package com.fafica.projeto.Endereco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.fafica.projeto.Funcionario.Funcionario;

public class RepositorioEnderecoBD implements IRepositorioEndereco{
	
	private Statement stm;
	private Connection con;
	
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

	@Override
	public void adicionar(Endereco endereco) throws EnderecoJaCadastradoException, SQLException {
		
		String query = "INSERT INTO ENDERECO(cpf,rua,numero,bairro,complemento,cidade,cep)" +
				"VALUES ('"+endereco.getCpf()+"', '"+endereco.getRua()+"' , '"+endereco.getNumero()+"', '"+endereco.getBairro()+"', '"+endereco.getComplemento()+"' , '"+endereco.getCidade()+"' , '"+endereco.getCep()+"')";
			
		conecta();
		try{
			stm = con.createStatement();
			stm.execute(query);
			stm.close();
			//JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
		} catch(SQLException sql){
			System.out.println("Erro no inserir Endereco "+sql);
		}
		desconecta();
		
	}//fim do adicionar

	@Override
	public void atualizar(Endereco endereco) throws EnderecoNaoEncontradoException {
		String query = "UPDATE ENDERECO SET rua=?,numero=?,complemento=?,bairro=?,cidade=?,cep=? WHERE cpf=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, endereco.getRua());
			stm.setString(2, endereco.getNumero());
			stm.setString(3, endereco.getComplemento());
			stm.setString(4, endereco.getBairro());
			stm.setString(5, endereco.getCidade());
			stm.setString(6, endereco.getCep());
			stm.setString(7, endereco.getCpf());
			stm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		} catch (SQLException sql){
			System.out.println("Erro no atualizar" +sql);
		}
		
	}//fim do atualiar

	@Override
	public Endereco buscar(String cpf) throws EnderecoNaoEncontradoException {
		//ArrayList<Endereco> enderecoBuscar = new ArrayList<>();
		String query = "select cpf,rua,numero,complemento,bairro,cidade,cep,bairro from endereco where CPF=?";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, cpf);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				   String cpf1 = rs.getString("cpf");
				   String rua = rs.getString("rua");
		    	   String numero = rs.getString("numero");
		    	   String complemento = rs.getString("complemento");
		    	   String bairro = rs.getString("bairro");
		    	   String cidade = rs.getString("cidade");
		    	   String cep = rs.getString("cep");
		    	   Endereco endereco = new Endereco(rua,numero,complemento,bairro,cidade,cep);
		    	  // enderecoBuscar.add(endereco);
		    	   //System.out.println(enderecoBuscar);
		    	   return endereco;
			}//fim do while
			JOptionPane.showMessageDialog(null, "Busca efetuada com sucesso!");
			stm.close();
			rs.close();
		} catch (SQLException sql){
			System.out.println("Erro no Buscarr" +sql);
		}//fim do try
		desconecta();
		return null;
		
		
	}//fim do atualizar

	@Override
	public void remover(String cpf) throws EnderecoNaoEncontradoException {
		String query = "DELETE FROM ENDERECO WHERE cpf=? ";
		conecta();
		try{
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, cpf);
			stm.executeUpdate();
			//JOptionPane.showMessageDialog(null, "Removido com sucesso!");
		} catch (SQLException sql){
			//System.out.println("Erro no remover" +sql);
		}
		
	}

	@Override
	public ArrayList<Endereco> listar() {
		ArrayList<Endereco> listar = new ArrayList<>();
		String query = "select * from ENDERECO";
		conecta();
		try{
		PreparedStatement stm = con.prepareStatement(query);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			   Endereco endereco = new Endereco(rs.getString("rua"),rs.getString("cpf"),rs.getString("numero"),rs.getString("complemento"),rs.getString("bairro"),rs.getString("cidade"),rs.getString("cep"));
	    	   listar.add(endereco);
		}//fim do while
		for(Endereco endereco : listar){
			System.out.println(endereco);
		}
		} catch(SQLException sql){
			System.out.println("Erro no listar:" + sql);
		}//fim do catch
		desconecta();
		return listar;
	}//fim do listar

	

}
