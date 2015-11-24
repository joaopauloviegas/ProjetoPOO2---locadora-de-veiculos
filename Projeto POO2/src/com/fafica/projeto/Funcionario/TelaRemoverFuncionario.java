package com.fafica.projeto.Funcionario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Cliente.CPFInvalidoException;
import com.fafica.projeto.Cliente.Cliente;
import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;
import com.fafica.projeto.Fachada.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRemoverFuncionario {

	public JFrame frmRemoverFuncionario;
	private JTextField textCpf;
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
					TelaRemoverFuncionario window = new TelaRemoverFuncionario();
					window.frmRemoverFuncionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRemoverFuncionario() {
		initialize();
		fachada = Fachada.getInstance();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRemoverFuncionario = new JFrame();
		frmRemoverFuncionario.setTitle("Remover Funcionario");
		frmRemoverFuncionario.setBounds(100, 100, 447, 329);
		frmRemoverFuncionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRemoverFuncionario.getContentPane().setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(12, 86, 56, 16);
		frmRemoverFuncionario.getContentPane().add(lblCpf);
		
		textCpf = new JTextField();
		textCpf.setBounds(46, 83, 148, 22);
		frmRemoverFuncionario.getContentPane().add(textCpf);
		textCpf.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					remover();
				} catch (EnderecoNaoEncontradoException | CPFInvalidoException
						| FuncionarioNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRemover.setBounds(206, 82, 97, 25);
		frmRemoverFuncionario.getContentPane().add(btnRemover);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 145, 293, 134);
		frmRemoverFuncionario.getContentPane().add(scrollPane);
		
		tableFuncionario = new JTable();
		String colunaTabelaFuncionario[] = new String[] {"Nome", "CPF"};
		defaultTableModelFuncionario = new DefaultTableModel(new Object[] []{ }, colunaTabelaFuncionario) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
	
		tableFuncionario.setModel(defaultTableModelFuncionario);
		scrollPane.setViewportView(tableFuncionario);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					listarFuncionario();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnListar.setBounds(313, 256, 89, 23);
		frmRemoverFuncionario.getContentPane().add(btnListar);
	
	}
	
	public void remover() throws EnderecoNaoEncontradoException, CPFInvalidoException, FuncionarioNaoEncontradoException {
		Fachada fachada = new Fachada();
		fachada.getInstance();
		try{		
		String cpf = textCpf.getText();
		fachada.removerEndereco(cpf);
		fachada.removerFuncionario(cpf);
		limparTabelaFuncionario();
		} catch(Exception e) {
			
		}
	}
	public void listarFuncionario() throws SQLException{
	    limparTabelaFuncionario();
		ArrayList<Funcionario> funcionarios = fachada.listarFuncionario();

		try{
			
			for (Funcionario funcionario : funcionarios) {
	
					
					Vector vector =  new Vector();
					vector.add(funcionario.getNome());
					vector.add(funcionario.getCpf());
				
					defaultTableModelFuncionario.addRow(vector);
				
			}// fim do for  
			
		}catch(Exception e){
			
		}//fim do try/catch
	
	}
	
	private void limparTabelaFuncionario() {
		  defaultTableModelFuncionario.setRowCount(0);
		}
	
}
