package com.fafica.projeto.CadastroDeReserva;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Cliente.CPFInvalidoException;
import com.fafica.projeto.Endereco.EnderecoNaoEncontradoException;
import com.fafica.projeto.Fachada.Fachada;
import com.fafica.projeto.Funcionario.Funcionario;
import com.fafica.projeto.Funcionario.FuncionarioNaoEncontradoException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRemoverCadastroDeReserva {

	public JFrame frame;
	private JTable table;
	private JTextField textPlaca;
	private DefaultTableModel DefaultTableCadastroDeReserva;
	private Fachada fachada;
	private CadastroDeReserva cadastrodeReserva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverCadastroDeReserva window = new TelaRemoverCadastroDeReserva();
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
	public TelaRemoverCadastroDeReserva() {
		initialize();
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 536, 351);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		btnListar.setBounds(421, 259, 89, 23);
		frame.getContentPane().add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 388, 197);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		String colunaTabelaCadastroDeReserva[] = new String[] {"Cliente", "Placa","Valor"};
		DefaultTableCadastroDeReserva = new DefaultTableModel(new Object[] []{ },colunaTabelaCadastroDeReserva ) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
	
		table.setModel(DefaultTableCadastroDeReserva);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Placa:");
		lblNewLabel.setBounds(10, 24, 65, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(52, 21, 100, 20);
		frame.getContentPane().add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnRemover.setBounds(178, 20, 89, 23);
		frame.getContentPane().add(btnRemover);
	}
	
	public void remover()  {
		Fachada fachada = new Fachada();
		fachada.getInstance();
		try{		
		String placa = textPlaca.getText();
		fachada.removerCadastroDeReserva(placa);
		limpar();
		} catch(Exception e) {
			
		}
	}
	
	public void listar() throws SQLException{
	    limpar();
		ArrayList<CadastroDeReserva> cadastroReserva = fachada.listarCadastroDeReserva();

		try{
			
			for (CadastroDeReserva cadastrodeReserva : cadastroReserva) {
	
					
					Vector vector =  new Vector();
					vector.add(cadastrodeReserva.getNomeCliente());
					vector.add(cadastrodeReserva.getPlaca());
					vector.add(cadastrodeReserva.getValor());
				
					DefaultTableCadastroDeReserva.addRow(vector);
				
			}// fim do for  
			
		}catch(Exception e){
			
		}//fim do try/catch
	
	}//fim do listar
	
	private void limpar() {
		  DefaultTableCadastroDeReserva.setRowCount(0);
		}
	

}
