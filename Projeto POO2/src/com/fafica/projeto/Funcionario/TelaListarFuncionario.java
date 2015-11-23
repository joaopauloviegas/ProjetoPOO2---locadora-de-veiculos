package com.fafica.projeto.Funcionario;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Endereco.Endereco;
import com.fafica.projeto.Fachada.Fachada;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListarFuncionario {

	private JFrame frame;
	private JTable tableFuncionario;
	private DefaultTableModel defaultTableModelFuncionario;
	private Fachada fachada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarFuncionario window = new TelaListarFuncionario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarFuncionario() {
		initialize();
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 852, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnListar.setBounds(737, 351, 89, 23);
		frame.getContentPane().add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 25, 804, 311);
		frame.getContentPane().add(scrollPane);
		
		tableFuncionario = new JTable();
		String colunaTabelaFuncionario[] = new String[] {"Nome", "CPF","Sexo","NumeroTelefone","Rua","Numero","Comeplemento","Bairro","Cidade","CEP"};
		defaultTableModelFuncionario = new DefaultTableModel(new Object[] []{ }, colunaTabelaFuncionario) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
	
		tableFuncionario.setModel(defaultTableModelFuncionario);
		scrollPane.setViewportView(tableFuncionario);
	
	
		
		
	}
	
	public void listar() throws SQLException{
	    limparTabelaFuncionario();
		ArrayList<Funcionario> funcionarios = fachada.listarFuncionario();
		ArrayList<Endereco> enderecos = fachada.listarEndereco();
		try{
			Vector vector = null;
			for (Funcionario funcionario : funcionarios) {
	
				for(Endereco endereco : enderecos){
				vector =  new Vector();
				vector.add(funcionario.getNome());
				vector.add(funcionario.getCpf());
				vector.add(funcionario.getSexo());
				vector.add(funcionario.getNumeroTelefone());
				vector.add(endereco.getRua());
				vector.add(endereco.getNumero());
				vector.add(endereco.getBairro());
				vector.add(endereco.getComplemento());
				vector.add(endereco.getCidade());
				vector.add(endereco.getCep());
				}
					defaultTableModelFuncionario.addRow(vector);
					
			}// fim do for  
			
		}catch(Exception e){
			
		}//fim do try/catch
	
	}
	
	private void limparTabelaFuncionario() {
		  defaultTableModelFuncionario.setRowCount(0);
		}
	
	

}
