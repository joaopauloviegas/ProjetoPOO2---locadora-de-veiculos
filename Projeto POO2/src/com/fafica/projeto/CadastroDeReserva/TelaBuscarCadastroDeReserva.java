package com.fafica.projeto.CadastroDeReserva;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.fafica.projeto.Fachada.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaBuscarCadastroDeReserva {

	public JFrame frame;
	private JTextField textPlaca;
	private JTextField textNomeCliente;
	private JTextField textNomeFuncionario;
	private JTextField textData;
	private JTextField textQuantidade;
	private JTextField textDiasComCarro;
	private JTextField textValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarCadastroDeReserva window = new TelaBuscarCadastroDeReserva();
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
	public TelaBuscarCadastroDeReserva() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 751, 383);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 27, 715, 306);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(10, 30, 46, 14);
		panel.add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(101, 27, 105, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procurar();
			}
		});
		btnProcurar.setBounds(216, 26, 89, 23);
		panel.add(btnProcurar);
		
		JLabel lblNewLabel = new JLabel("Nome Cliente:");
		lblNewLabel.setBounds(10, 67, 81, 14);
		panel.add(lblNewLabel);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setBounds(101, 64, 504, 20);
		panel.add(textNomeCliente);
		textNomeCliente.setColumns(10);
		
		JLabel lblNomeFuncionario = new JLabel("Nome Funcionario:");
		lblNomeFuncionario.setBounds(10, 92, 81, 14);
		panel.add(lblNomeFuncionario);
		
		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setBounds(101, 89, 504, 20);
		panel.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 117, 46, 14);
		panel.add(lblData);
		
		textData = new JTextField();
		textData.setBounds(101, 114, 105, 20);
		panel.add(textData);
		textData.setColumns(10);
		
		JLabel lblDiasComCarro = new JLabel("Quantidade:");
		lblDiasComCarro.setBounds(10, 142, 81, 14);
		panel.add(lblDiasComCarro);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(101, 139, 105, 20);
		panel.add(textQuantidade);
		textQuantidade.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dias com Carro:");
		lblNewLabel_2.setBounds(10, 165, 81, 14);
		panel.add(lblNewLabel_2);
		
		textDiasComCarro = new JTextField();
		textDiasComCarro.setBounds(101, 162, 105, 20);
		panel.add(textDiasComCarro);
		textDiasComCarro.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 187, 46, 14);
		panel.add(lblValor);
		
		textValor = new JTextField();
		textValor.setBounds(101, 184, 105, 20);
		panel.add(textValor);
		textValor.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(616, 272, 89, 23);
		panel.add(btnLimpar);
	}
	
	public void procurar(){
		Fachada fachada = new Fachada();
		fachada.getInstance();
		try{
		String placa = textPlaca.getText();
		CadastroDeReserva cadastrodeReserva = fachada.buscarCadastroDeReserva(placa);
		
		textNomeCliente.setText(cadastrodeReserva.getNomeCliente());
		textNomeFuncionario.setText(cadastrodeReserva.getNomeFuncionario());
		textData.setText(cadastrodeReserva.getData());
		String quantidadeString = String.valueOf(cadastrodeReserva.getQuantidade());
		textQuantidade.setText(quantidadeString);
		String DiasComCarroString = String.valueOf(cadastrodeReserva.getDiascomCarro());
		textDiasComCarro.setText(DiasComCarroString);
		String valorTotal = String.valueOf(cadastrodeReserva.getValor());
		textValor.setText(valorTotal);
		
		}catch(Exception e){
			
		}
	}//fim do procurar
	
	public void limpar(){
		textNomeCliente.setText("");
		textNomeFuncionario.setText("");
		textData.setText("");
		textPlaca.setText("");
		textQuantidade.setText("");
		textDiasComCarro.setText("");
		textValor.setText("");
	}

}
