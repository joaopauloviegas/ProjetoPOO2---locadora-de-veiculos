package com.fafica.projeto.Carro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
import java.awt.Font;

public class TelaProcurarCarro {

	public JFrame frmTelaProcurarCarro;
	private JTextField textPlaca;
	private JTextField textId;
	private JTextField textNome;
	private JTextField textAno;
	private JTextField textPorta;
	private JTextField textKm;
	private JTextField textCategoria;
	private Carro carro;
	private JScrollPane scrollPane;
	private JTable tableCarro;
	private DefaultTableModel defaultTableModelCarro;
	private Fachada fachada;
	private JButton btnListar;
	private JButton btnLimparTabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProcurarCarro window = new TelaProcurarCarro();
					window.frmTelaProcurarCarro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaProcurarCarro() {
		initialize();
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaProcurarCarro = new JFrame();
		frmTelaProcurarCarro.setTitle("Tela Procurar Carro");
		frmTelaProcurarCarro.setBounds(100, 100, 748, 261);
		frmTelaProcurarCarro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaProcurarCarro.getContentPane().setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlaca.setBounds(10, 43, 46, 14);
		frmTelaProcurarCarro.getContentPane().add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(76, 40, 98, 20);
		frmTelaProcurarCarro.getContentPane().add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurar();
			}
		});
		btnProcurar.setBounds(187, 38, 117, 23);
		frmTelaProcurarCarro.getContentPane().add(btnProcurar);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(10, 95, 46, 14);
		frmTelaProcurarCarro.getContentPane().add(lblId);
		
		textId = new JTextField();
		textId.setBounds(76, 92, 64, 20);
		frmTelaProcurarCarro.getContentPane().add(textId);
		textId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(10, 126, 46, 14);
		frmTelaProcurarCarro.getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(76, 123, 255, 20);
		frmTelaProcurarCarro.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAno.setBounds(10, 151, 46, 14);
		frmTelaProcurarCarro.getContentPane().add(lblAno);
		
		JLabel lblNewLabel = new JLabel("Portas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(245, 176, 46, 14);
		frmTelaProcurarCarro.getContentPane().add(lblNewLabel);
		
		textAno = new JTextField();
		textAno.setBounds(76, 148, 76, 20);
		frmTelaProcurarCarro.getContentPane().add(textAno);
		textAno.setColumns(10);
		
		textPorta = new JTextField();
		textPorta.setBounds(292, 173, 39, 20);
		frmTelaProcurarCarro.getContentPane().add(textPorta);
		textPorta.setColumns(10);
		
		JLabel lblKm = new JLabel("Km:");
		lblKm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKm.setBounds(209, 151, 39, 14);
		frmTelaProcurarCarro.getContentPane().add(lblKm);
		
		textKm = new JTextField();
		textKm.setBounds(245, 148, 86, 20);
		frmTelaProcurarCarro.getContentPane().add(textKm);
		textKm.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategoria.setBounds(10, 176, 64, 14);
		frmTelaProcurarCarro.getContentPane().add(lblCategoria);
		
		textCategoria = new JTextField();
		textCategoria.setBounds(76, 173, 125, 20);
		frmTelaProcurarCarro.getContentPane().add(textCategoria);
		textCategoria.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(450, 11, 272, 145);
		frmTelaProcurarCarro.getContentPane().add(scrollPane);
		
		tableCarro = new JTable();
		String colunaTabelaCarro[] = new String[] {"Nome", "Placa"};
		defaultTableModelCarro = new DefaultTableModel(new Object[] []{ }, colunaTabelaCarro) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		tableCarro.setModel(defaultTableModelCarro);
		scrollPane.setViewportView(tableCarro);
		
		btnListar = new JButton("Listar");
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
		btnListar.setBounds(633, 172, 89, 23);
		frmTelaProcurarCarro.getContentPane().add(btnListar);
		
		btnLimparTabela = new JButton("Limpar tabela");
		btnLimparTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparTabelaCarro();
			}
		});
		btnLimparTabela.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimparTabela.setBounds(491, 171, 132, 23);
		frmTelaProcurarCarro.getContentPane().add(btnLimparTabela);
		
		JLabel lblDigiteAPlaca = new JLabel("Digite a PLACA que deseja procurar");
		lblDigiteAPlaca.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDigiteAPlaca.setBounds(50, 8, 248, 21);
		frmTelaProcurarCarro.getContentPane().add(lblDigiteAPlaca);
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
			textId.setText(id);
			textNome.setText(carro.getNome());
			textKm.setText(km);
			textPorta.setText(porta);
			
			
		}catch(Exception e){
			
		}
		
	}// fim do metodo procurar
	
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
}//fim da classe
