package com.fafica.projeto.Carro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.fafica.projeto.Fachada.Fachada;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaProcurarCarro {

	public JFrame frame;
	private JTextField textPlaca;
	private JTextField textId;
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
					TelaProcurarCarro window = new TelaProcurarCarro();
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
	public TelaProcurarCarro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 366, 273);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(10, 29, 46, 14);
		frame.getContentPane().add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(66, 26, 98, 20);
		frame.getContentPane().add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurar();
			}
		});
		btnProcurar.setBounds(174, 25, 89, 23);
		frame.getContentPane().add(btnProcurar);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 95, 46, 14);
		frame.getContentPane().add(lblId);
		
		textId = new JTextField();
		textId.setBounds(76, 92, 64, 20);
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 126, 46, 14);
		frame.getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(76, 123, 255, 20);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(10, 151, 46, 14);
		frame.getContentPane().add(lblAno);
		
		JLabel lblNewLabel = new JLabel("Portas:");
		lblNewLabel.setBounds(245, 176, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textAno = new JTextField();
		textAno.setBounds(76, 148, 76, 20);
		frame.getContentPane().add(textAno);
		textAno.setColumns(10);
		
		textPorta = new JTextField();
		textPorta.setBounds(292, 173, 39, 20);
		frame.getContentPane().add(textPorta);
		textPorta.setColumns(10);
		
		JLabel lblKm = new JLabel("Km:");
		lblKm.setBounds(209, 151, 39, 14);
		frame.getContentPane().add(lblKm);
		
		textKm = new JTextField();
		textKm.setBounds(245, 148, 86, 20);
		frame.getContentPane().add(textKm);
		textKm.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(10, 176, 64, 14);
		frame.getContentPane().add(lblCategoria);
		
		textCategoria = new JTextField();
		textCategoria.setBounds(76, 173, 125, 20);
		frame.getContentPane().add(textCategoria);
		textCategoria.setColumns(10);
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
}//fim da classe
