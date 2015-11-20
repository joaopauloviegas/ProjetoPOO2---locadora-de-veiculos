package com.fafica.projeto.Carro;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Fachada.Fachada;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaListarCarro {

	public JFrame frame;
	private JTable tableCarro;
	private DefaultTableModel defaultTableModelCarro;
	private Fachada fachada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarCarro window = new TelaListarCarro();
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
	public TelaListarCarro() {
		initialize();
		
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 717, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 681, 276);
		frame.getContentPane().add(scrollPane);
		
		tableCarro = new JTable();
		String colunaTabelaCarro[] = new String[] {"ID", "Nome", "Ano", "Placa", "Portas", "Km", "Categoria"};
		defaultTableModelCarro = new DefaultTableModel(new Object[] []{ }, colunaTabelaCarro) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		tableCarro.setModel(defaultTableModelCarro);
		scrollPane.setViewportView(tableCarro);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 304, 681, 71);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					listar();
				} catch (SQLException | CarroNaoEncontradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnListar.setBounds(595, 27, 76, 23);
		panel.add(btnListar);
		
		JButton btnLimparTabela = new JButton("Limpar tabela");
		btnLimparTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTabelaCarro();
			}
		});
		btnLimparTabela.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimparTabela.setBounds(446, 27, 139, 23);
		panel.add(btnLimparTabela);
		
	}
	
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
