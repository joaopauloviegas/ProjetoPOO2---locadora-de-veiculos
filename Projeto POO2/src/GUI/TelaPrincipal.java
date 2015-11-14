package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.fafica.projeto.Cliente.TelaCadastroCliente;
import com.fafica.projeto.Cliente.TelaRemoverCliente;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
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
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 708, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 692, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnCadastrar = new JMenu("CADASTRAR");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmCarro = new JMenuItem("Carro");
		mntmCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnCadastrar.add(mntmCarro);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente window = new TelaCadastroCliente();
				window.frmTelaCadastroCliente.setVisible(true);
				
			}
		});
		mnCadastrar.add(mntmCliente);
		
		JMenuItem mntmSaidaDeVeiculo = new JMenuItem("Saida de veiculo");
		mnCadastrar.add(mntmSaidaDeVeiculo);
		
		JMenu mnAtualizar = new JMenu("ATUALIZAR");
		menuBar.add(mnAtualizar);
		
		JMenuItem mntmCarro_1 = new JMenuItem("Carro");
		mnAtualizar.add(mntmCarro_1);
		
		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mnAtualizar.add(mntmCliente_1);
		
		JMenuItem mntmSaidaDeVeiculo_1 = new JMenuItem("Saida de Veiculo");
		mnAtualizar.add(mntmSaidaDeVeiculo_1);
		
		JMenu mnRemover = new JMenu("REMOVER");
		menuBar.add(mnRemover);
		
		JMenuItem mntmCarro_2 = new JMenuItem("Carro");
		mnRemover.add(mntmCarro_2);
		
		JMenuItem mntmCliente_2 = new JMenuItem("Cliente");
		mntmCliente_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverCliente telaRemover = new TelaRemoverCliente();
				telaRemover.frmTelaRemoverCliente.setVisible(true);
			}
		});
		mnRemover.add(mntmCliente_2);
		
		JMenuItem mntmSaidaDeVeiculo_2 = new JMenuItem("Saida de Veiculo");
		mnRemover.add(mntmSaidaDeVeiculo_2);
		
		JMenu mnProcurar = new JMenu("PROCURAR");
		menuBar.add(mnProcurar);
		
		JMenuItem mntmCarro_3 = new JMenuItem("Carro");
		mnProcurar.add(mntmCarro_3);
		
		JMenuItem mntmCliente_3 = new JMenuItem("Cliente");
		mnProcurar.add(mntmCliente_3);
		
		JMenuItem mntmSaidaDeVeiculo_3 = new JMenuItem("Saida de veiculo");
		mnProcurar.add(mntmSaidaDeVeiculo_3);
	}

}
