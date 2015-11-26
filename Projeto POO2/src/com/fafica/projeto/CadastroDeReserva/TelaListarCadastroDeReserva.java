package com.fafica.projeto.CadastroDeReserva;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto.CadastroSaidaDeVeiculos.CadastroSaidaDeVeiculos;
import com.fafica.projeto.Carro.CarroNaoEncontradoException;
import com.fafica.projeto.Fachada.Fachada;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListarCadastroDeReserva {

	public JFrame frmListagemCadastroDe;
	private JTable table;
	private DefaultTableModel DefaultTablecadastrodeReserva;
	private Fachada fachada;
	private CadastroDeReserva cadastrodeReserva;
	private JTable tableCadastroDeReserva;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarCadastroDeReserva window = new TelaListarCadastroDeReserva();
					window.frmListagemCadastroDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarCadastroDeReserva() {
		initialize();
		fachada = Fachada.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListagemCadastroDe = new JFrame();
		frmListagemCadastroDe.setTitle("Listagem Cadastro de Reserva");
		frmListagemCadastroDe.setBounds(100, 100, 802, 360);
		frmListagemCadastroDe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListagemCadastroDe.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 766, 248);
		frmListagemCadastroDe.getContentPane().add(scrollPane);
		
		tableCadastroDeReserva = new JTable();
		String colunaTabelaCadastroDeReserva[] = new String[] {"Cliente", "Funcionario", "Data", "Placa","Quantidade","Dias C/Carro", "Valor"};
		DefaultTablecadastrodeReserva = new DefaultTableModel(new Object[] []{ },colunaTabelaCadastroDeReserva) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		tableCadastroDeReserva.setModel(DefaultTablecadastrodeReserva);
		scrollPane.setViewportView(tableCadastroDeReserva);
						
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
		btnListar.setBounds(687, 283, 89, 23);
		frmListagemCadastroDe.getContentPane().add(btnListar);
	}
	
	public void listar() throws SQLException, CarroNaoEncontradoException{

		ArrayList<CadastroDeReserva> reservaVeiculo = fachada.listarCadastroDeReserva();

		try{
			for (CadastroDeReserva cadastrodeReserva: reservaVeiculo) {
				Vector vector = new Vector();
				vector.add(cadastrodeReserva.getNomeCliente());
				vector.add(cadastrodeReserva.getNomeFuncionario());
				vector.add(cadastrodeReserva.getData());
				vector.add(cadastrodeReserva.getPlaca());
				vector.add(cadastrodeReserva.getQuantidade());
				vector.add(cadastrodeReserva.getDiascomCarro());
				vector.add(cadastrodeReserva.getValor());
				DefaultTablecadastrodeReserva.addRow(vector);
			
				
			}//fim do for
		
		}catch(Exception e){
			
		}//fim do try/catch     
		
	}// fim do metodo listar
}
