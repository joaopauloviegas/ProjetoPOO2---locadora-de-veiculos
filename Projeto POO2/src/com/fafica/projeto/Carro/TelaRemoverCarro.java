package com.fafica.projeto.Carro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Fachada.Fachada;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaRemoverCarro {

	public JFrame frmTelaRemoverCarro;
	private JTextField textPlaca;
	private JTable tableLCarro;
	private DefaultTableModel defaultTableModelCarro;
	private JTable tableCarro;
	private Fachada fachada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverCarro window = new TelaRemoverCarro();
					window.frmTelaRemoverCarro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRemoverCarro() {
		initialize();
		fachada= Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaRemoverCarro = new JFrame();
		frmTelaRemoverCarro.setTitle("Tela Remover Carro");
		frmTelaRemoverCarro.setBounds(100, 100, 776, 461);
		frmTelaRemoverCarro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTelaRemoverCarro.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 57, 740, 101);
		frmTelaRemoverCarro.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Placa:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 46, 46, 14);
		panel.add(lblNewLabel);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(66, 43, 86, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnRemover.setBounds(178, 42, 111, 23);
		panel.add(btnRemover);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(216, 11, 406, 35);
		frmTelaRemoverCarro.getContentPane().add(panel_1);
		
		JLabel lblDigiteAPlaca = new JLabel("Digite a placa do carro que deseja remover");
		lblDigiteAPlaca.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(lblDigiteAPlaca);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 180, 740, 202);
		frmTelaRemoverCarro.getContentPane().add(scrollPane);
		
		tableCarro = new JTable();
		String colunaTabelaCarro[] = new String[] {"ID", "Nome", "Ano", "Placa", "Portas", "Km", "Categoria"};
		defaultTableModelCarro = new DefaultTableModel(new Object[] []{ }, colunaTabelaCarro) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		tableCarro.setModel(defaultTableModelCarro);
		scrollPane.setViewportView(tableCarro);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listar();
				} catch (SQLException | CarroNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListar.setBounds(654, 393, 96, 23);
		frmTelaRemoverCarro.getContentPane().add(btnListar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(555, 393, 89, 23);
		frmTelaRemoverCarro.getContentPane().add(btnLimpar);
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		
		
	}// fim do main
	
	
	public void limparCampos(){
		textPlaca.setText("");
		limparTabelaCarro();
	}
	
	public void remover(){
		//Fachada fachada = new Fachada();
		//fachada.getInstance();
		
		try{
			fachada.removerCarro(textPlaca.getText());
			JOptionPane.showMessageDialog(null, "Carro removido com sucesso");
			limparCampos();
		}catch(Exception e){
			
		}
		
		
	}// fim do metodo remover
	
	public void listar() throws SQLException, CarroNaoEncontradoException{
		limparTabelaCarro();
		ArrayList<Carro> carros = fachada.listarCarro();

		try{
			for (Carro carro : carros) {
				Vector vector = new Vector();
				vector.add(carro.getId());
				vector.add(carro.getNome());
				vector.add(carro.getAno());
				vector.add(carro.getPlaca());
				vector.add(carro.getQuantidadePorta());
				vector.add(carro.getQuilometragem());
				vector.add(carro.getCategoria());
				defaultTableModelCarro.addRow(vector);
			}//fim do for
		}catch(Exception e){
			
		}//fim do try/catch     
		
	}// fim do metodo listar
	
	private void limparTabelaCarro() {
	  defaultTableModelCarro.setRowCount(0);
	}

}// fim da classe 
