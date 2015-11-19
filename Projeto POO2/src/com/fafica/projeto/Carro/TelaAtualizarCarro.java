package com.fafica.projeto.Carro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.Fachada.Fachada;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaAtualizarCarro {

	public JFrame frmTelaAtualizarCarro;
	private JTextField textPlaca;
	private JTextField textNome;
	private JTextField textAno;
	private JTextField textPorta;
	private JTextField textKm;
	private JTextField textCategoria;
	private Carro carro;
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
					TelaAtualizarCarro window = new TelaAtualizarCarro();
					window.frmTelaAtualizarCarro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAtualizarCarro() {
		initialize();
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaAtualizarCarro = new JFrame();
		frmTelaAtualizarCarro.setTitle("Tela Atualizar Carro");
		frmTelaAtualizarCarro.setBounds(100, 100, 659, 397);
		frmTelaAtualizarCarro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaAtualizarCarro.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 623, 100);
		frmTelaAtualizarCarro.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDigiteAPlaca = new JLabel("Digite a PLACA do veiculo que deseja atualiizar");
		lblDigiteAPlaca.setBounds(159, 5, 304, 16);
		lblDigiteAPlaca.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblDigiteAPlaca);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlaca.setBounds(10, 60, 46, 14);
		panel.add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(66, 57, 86, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procurar();
			}
		});
		btnProcurar.setBounds(174, 56, 89, 23);
		panel.add(btnProcurar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 122, 623, 225);
		frmTelaAtualizarCarro.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(10, 11, 46, 14);
		panel_1.add(lblNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textNome.setBounds(66, 8, 285, 20);
		panel_1.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAno.setBounds(392, 36, 35, 14);
		panel_1.add(lblAno);
		
		textAno = new JTextField();
		textAno.setBounds(437, 33, 66, 20);
		panel_1.add(textAno);
		textAno.setColumns(10);
		
		JLabel lblPortas = new JLabel("Portas:");
		lblPortas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPortas.setBounds(10, 36, 46, 14);
		panel_1.add(lblPortas);
		
		textPorta = new JTextField();
		textPorta.setBounds(66, 33, 66, 20);
		panel_1.add(textPorta);
		textPorta.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Categoria:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(361, 11, 66, 14);
		panel_1.add(lblNewLabel);
		
		textCategoria = new JTextField();
		textCategoria.setBounds(437, 8, 176, 20);
		panel_1.add(textCategoria);
		textCategoria.setColumns(10);
		
		JLabel lblKm = new JLabel("Km:");
		lblKm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKm.setBounds(193, 36, 27, 14);
		panel_1.add(lblKm);
		
		textKm = new JTextField();
		textKm.setBounds(230, 33, 121, 20);
		panel_1.add(textKm);
		textKm.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnAtualizar.setBounds(505, 191, 108, 23);
		panel_1.add(btnAtualizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(406, 190, 89, 23);
		panel_1.add(btnLimpar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 264, 143);
		panel_1.add(scrollPane);
		
		tableCarro = new JTable();
		String colunaTabelaCarro[] = new String[] {"Nome", "Placa"};
		defaultTableModelCarro = new DefaultTableModel(new Object[] []{ }, colunaTabelaCarro) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		tableCarro.setModel(defaultTableModelCarro);
		scrollPane.setViewportView(tableCarro);
		
		JButton btnListar = new JButton("Listar");
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
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListar.setBounds(307, 191, 89, 23);
		panel_1.add(btnListar);
	}// fim do main
	
	public void procurar(){
		Fachada fachada = new Fachada();
		fachada.getInstance();
		try{
			String placa = textPlaca.getText();
			carro = fachada.procurarCarro(placa);
			
			//convertendo valores para String
			String ano = Integer.toString(carro.getAno());
			String id = Integer.toString(carro.getId());
			String porta = Integer.toString(carro.getQuantidadePorta());
			String km = String.valueOf(carro.getQuilometragem());
			
			textAno.setText(ano);
			textCategoria.setText(carro.getCategoria());
			textNome.setText(carro.getNome());
			textKm.setText(km);
			textPorta.setText(porta);
			
			
		}catch(Exception e){
			
		}
		
	
	
	}// fim do metodo procurar
	
	public void atualizar(){
		Fachada fachada = new Fachada();
		fachada.getInstance();
		
		int ano = Integer.parseInt(textAno.getText());
		String categoria = textCategoria.getText();
		String nome = textNome.getText();
		double quilometragem = Double.parseDouble(textKm.getText());
		int quantidadePorta = Integer.parseInt(textPorta.getText());
		String placa = textPlaca.getText();
		
		
		try{
			Carro carro = new Carro(nome, ano, placa, quantidadePorta, quilometragem, categoria); 
			fachada.atualizarCarro(carro);
			JOptionPane.showMessageDialog(null, "Carro atualizado com sucesso!");
			limparCampos();
		}catch(Exception e){
			
		}
		
		}// fim do metodo cadastrar
	
	public void limparCampos(){
		textAno.setText("");
		textCategoria.setText("");
		textNome.setText("");
		textKm.setText("");
		textPorta.setText("");
		textPlaca.setText("");

	}
	
	public void listar() throws SQLException, CarroNaoEncontradoException{
		limparTabelaCarro();
		ArrayList<Carro> carros = fachada.listarCarro();

		try{
			for (Carro carro : carros) {
				Vector vector = new Vector();
				vector.add(carro.getNome());
				vector.add(carro.getPlaca());
				
				defaultTableModelCarro.addRow(vector);
			}//fim do for
		}catch(Exception e){
			
		}//fim do try/catch     
		
	}// fim do metodo listar
	
	private void limparTabelaCarro() {
		defaultTableModelCarro.setRowCount(0);
	}
}// fim da classe
