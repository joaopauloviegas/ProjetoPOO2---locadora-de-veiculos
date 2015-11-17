package com.fafica.projeto.Carro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.fafica.projeto.Fachada.Fachada;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualizarCarro {

	public JFrame frmTelaAtualizarCarro;
	private JTextField textPlaca;
	private JTextField textNome;
	private JTextField textAno;
	private JTextField textPorta;
	private JTextField textKm;
	private JTextField textCategoria;
	private Carro carro;

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
		lblPlaca.setBounds(10, 60, 46, 14);
		panel.add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(66, 57, 86, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
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
		lblNome.setBounds(10, 11, 46, 14);
		panel_1.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(66, 8, 285, 20);
		panel_1.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(392, 36, 35, 14);
		panel_1.add(lblAno);
		
		textAno = new JTextField();
		textAno.setBounds(437, 33, 66, 20);
		panel_1.add(textAno);
		textAno.setColumns(10);
		
		JLabel lblPortas = new JLabel("Portas:");
		lblPortas.setBounds(10, 36, 46, 14);
		panel_1.add(lblPortas);
		
		textPorta = new JTextField();
		textPorta.setBounds(66, 33, 66, 20);
		panel_1.add(textPorta);
		textPorta.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Categoria:");
		lblNewLabel.setBounds(361, 11, 66, 14);
		panel_1.add(lblNewLabel);
		
		textCategoria = new JTextField();
		textCategoria.setBounds(437, 8, 176, 20);
		panel_1.add(textCategoria);
		textCategoria.setColumns(10);
		
		JLabel lblKm = new JLabel("Km:");
		lblKm.setBounds(193, 36, 27, 14);
		panel_1.add(lblKm);
		
		textKm = new JTextField();
		textKm.setBounds(230, 33, 121, 20);
		panel_1.add(textKm);
		textKm.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnAtualizar.setBounds(524, 191, 89, 23);
		panel_1.add(btnAtualizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(425, 191, 89, 23);
		panel_1.add(btnLimpar);
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
	
	
}// fim da classe
