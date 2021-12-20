package gnomIoT.view;

import java.util.Map;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gnomIoT.entities.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;


public class TelaAdicionarDispositivo {

	private JFrame frame;
	
	// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	private JTextField txtNome;

	private static GnomIoT gnomiot;
	private JLabel lblNome;
	private JLabel lblModelo;

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdicionarDispositivo window = new TelaAdicionarDispositivo(gnomiot);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdicionarDispositivo window = new TelaAdicionarDispositivo(gnomiot);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	/**
	 * Create the application.
	 */
	public TelaAdicionarDispositivo(GnomIoT _gnomiot) {
		gnomiot = _gnomiot;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(new ImageIcon(this.getClass().getResource("/CasaIcone.png")).getImage());
		frame.setTitle("GNOMIOT");
		frame.getContentPane().setBackground(new Color(255, 250, 250));
		frame.setResizable(false);
		frame.setBounds(-1, -1, WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdicionarDispositivo = new JLabel("Adicionar Dispositivo");
		lblAdicionarDispositivo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblAdicionarDispositivo.setBounds(113, 124, 149, 15);
		frame.getContentPane().add(lblAdicionarDispositivo);
		
		txtNome = new JTextField();
		txtNome.setText("");
		txtNome.setBounds(51, 204, 256, 31);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		Map<String, Dispositivo> dispositivos = gnomiot.getDispositivos();
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBox.setBorder(null);
		comboBox.setBounds(51, 276, 256, 24);
		for (String dispModelo : dispositivos.keySet()) {
			comboBox.addItem(dispModelo);
		}
		frame.getContentPane().add(comboBox);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBorder(null);
		btnAdicionar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nome = txtNome.getText();
				String modelo = comboBox.getSelectedItem().toString();
				
				if(nome.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Dê um nome ao dispositivo!");
				} else {
					gnomiot.adicionarDispositivoAoComodo(nome, modelo);
					JOptionPane.showMessageDialog(null,"Dispositivo adicionado");
					
					TelaDispositivos telaDispositivos = new TelaDispositivos(gnomiot);
					
					// fecha janela atual
					frame.dispose();
					
					// abre a proxima
					//telaDispositivos.main(null);
					telaDispositivos.start();
				}
			}
		});
		btnAdicionar.setBounds(125, 370, 117, 25);
		frame.getContentPane().add(btnAdicionar);		
		
		// JButton btnVoltar = new JButton("←");
		// btnVoltar.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		TelaDispositivos telaDispositivos = new TelaDispositivos(gnomiot);
				
		// 		// fecha janela atual
		// 		frame.dispose();
				
		// 		// abre a proxima
		// 		//telaDispositivos.main(null);
		// 		telaDispositivos.start();
		// 	}
		// });
		// btnVoltar.setBounds(12, 12, 59, 25);
		// frame.getContentPane().add(btnVoltar);
		
		// JButton btnSair = new JButton("Sair");
		// btnSair.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		int reply = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);
		//         if (reply == JOptionPane.YES_OPTION) {
		//         	gnomiot.logout();
		        	
		//         	TelaLogin telaLogin = new TelaLogin(gnomiot);
					
		// 			// fecha janela atual
		// 			frame.dispose();
					
		// 			// abre a proxima
		// 			telaLogin.start();
		// 			//telaLogin.main(null);
		//         }
		// 	}
		// });
		// btnSair.setBounds(268, 12, 80, 25);
		// frame.getContentPane().add(btnSair);

		JButton btnVoltar = new JButton("");

		ImageIcon imgVoltar = new ImageIcon(this.getClass().getResource("/voltar.png"));
		btnVoltar.setIcon(imgVoltar);

		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBackground(new Color(0, 191, 255));
		btnVoltar.setBorder(null);
		btnVoltar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDispositivos telaDispositivos = new TelaDispositivos(gnomiot);
				// fecha janela atual
				frame.dispose();
				
				// abre a proxima
				//telaDispositivos.main(null);
				telaDispositivos.start();
			}
		});
		btnVoltar.setBounds(10, 11, 59, 26);
		frame.getContentPane().add(btnVoltar);
		ImageIcon imgSair = new ImageIcon(this.getClass().getResource("/sair.png"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 344, 50);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(255, 5, 79, 33);
		panel.add(btnSair);
		btnSair.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnSair.setForeground(new Color(255, 250, 250));
		btnSair.setIcon(imgSair);
		
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setBackground(new Color(0, 191, 255));
		btnSair.setBorder(null);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					gnomiot.logout();
					
					TelaLogin telaLogin = new TelaLogin(gnomiot);
					
					// fecha janela atual
					frame.dispose();
					
					// abre a proxima
					//telaLogin.main(null);
					telaLogin.start();
				}
			}
		});
		
		
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNome.setBounds(57, 185, 70, 15);
		frame.getContentPane().add(lblNome);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblModelo.setBounds(57, 259, 70, 15);
		frame.getContentPane().add(lblModelo);
		
		
		
	}
}
