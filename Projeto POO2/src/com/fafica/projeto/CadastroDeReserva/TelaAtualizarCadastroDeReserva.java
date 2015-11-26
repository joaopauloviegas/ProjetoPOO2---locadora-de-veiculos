package com.fafica.projeto.CadastroDeReserva;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.fafica.projeto.CadastroSaidaDeVeiculos.CadastroSaidaDeVeiculos;
import com.fafica.projeto.Fachada.Fachada;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualizarCadastroDeReserva {

	public JFrame frame;
	private JTextField textPlaca;
	private JTextField textNomeCliente;
	private JTextField textNomeFuncionario;
	private JTextField textData;
	private JTextField textQuantidade;
	private JTextField textDiasComCarro;
	private JTextField textValor;
	private CadastroDeReserva cadastrodeReserva;
	private Fachada fachada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarCadastroDeReserva window = new TelaAtualizarCadastroDeReserva();
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
	public TelaAtualizarCadastroDeReserva() {
		initialize();
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 737, 391);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 11, 675, 71);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(10, 27, 46, 14);
		panel.add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(61, 24, 109, 20);
		panel.add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					procurar();
				} catch (CadastroDeReservaNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnProcurar.setBounds(202, 23, 89, 23);
		panel.add(btnProcurar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(23, 105, 675, 204);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNomeCliente = new JLabel("Nome Cliente:");
		lblNomeCliente.setBounds(10, 11, 67, 14);
		panel_1.add(lblNomeCliente);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setBounds(87, 8, 578, 20);
		panel_1.add(textNomeCliente);
		textNomeCliente.setColumns(10);
		
		JLabel lblNomeFuncionario = new JLabel("Nome Funcionario:");
		lblNomeFuncionario.setBounds(10, 36, 67, 14);
		panel_1.add(lblNomeFuncionario);
		
		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setBounds(87, 33, 578, 20);
		panel_1.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 61, 46, 14);
		panel_1.add(lblData);
		
		textData = new JTextField();
		textData.setBounds(87, 58, 96, 20);
		panel_1.add(textData);
		textData.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(10, 86, 67, 14);
		panel_1.add(lblQuantidade);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(87, 83, 86, 20);
		panel_1.add(textQuantidade);
		textQuantidade.setColumns(10);
		
		JLabel lblDiasComCarro = new JLabel("Dias com Carro");
		lblDiasComCarro.setBounds(10, 110, 72, 14);
		panel_1.add(lblDiasComCarro);
		
		textDiasComCarro = new JTextField();
		textDiasComCarro.setBounds(87, 107, 86, 20);
		panel_1.add(textDiasComCarro);
		textDiasComCarro.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 158, 46, 14);
		panel_1.add(lblValor);
		
		textValor = new JTextField();
		textValor.setBounds(87, 155, 86, 20);
		panel_1.add(textValor);
		textValor.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnAtualizar.setBounds(609, 318, 89, 23);
		frame.getContentPane().add(btnAtualizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(510, 318, 89, 23);
		frame.getContentPane().add(btnLimpar);
	}

	public void procurar() throws CadastroDeReservaNaoEncontradoException{
		String placa = textPlaca.getText();
		cadastrodeReserva = fachada.buscarCadastroDeReserva(placa);
		
		textNomeCliente.setText(cadastrodeReserva.getNomeCliente());
		textNomeFuncionario.setText(cadastrodeReserva.getNomeFuncionario());
		textData.setText(cadastrodeReserva.getData());
		String quantidade = String.valueOf(cadastrodeReserva.getQuantidade());
		textQuantidade.setText(quantidade);
		String DiasComCarro = String.valueOf(cadastrodeReserva.getDiascomCarro());
		textDiasComCarro.setText(DiasComCarro);
		String valorTotal1 = String.valueOf(cadastrodeReserva.getValor());
		textValor.setText(valorTotal1);
		
	}
	
	
       public void atualizar(){
		
		String nomeCliente = textNomeCliente.getText();
		String nomeFuncionario = textNomeFuncionario.getText();
		String data = textData.getText();
		String Quantidade1 = textQuantidade.getText();
		int Quantidade = Integer.parseInt(Quantidade1);
		String DiasComCarro1 = textDiasComCarro.getText();
		int diascomCarro = Integer.parseInt(DiasComCarro1);
		String valorTotal = textValor.getText();
		double valor =  Double.parseDouble(valorTotal);
		String placa = textPlaca.getText();
		
		try{
			
			cadastrodeReserva = new CadastroDeReserva(nomeCliente, nomeFuncionario, data,placa,Quantidade,diascomCarro, valor);
			fachada.atualizarCadastroDeReserva(cadastrodeReserva);
			JOptionPane.showMessageDialog(null, "Saida de veiculo atualizada com sucesso!");
			limpar();
			
					
		}catch(Exception e ){
			
		}
		
	}// fim do metodo atualizar
	
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
