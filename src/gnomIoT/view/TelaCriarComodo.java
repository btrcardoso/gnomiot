package gnomIoT.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gnomIoT.entities.GnomIoT;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;

public class TelaCriarComodo {

	private JFrame frame;
	
	// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	private JTextField txtNome;

	private static GnomIoT gnomiot;

	/**
	 * Launch the application.
	 */
	
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCriarComodo window = new TelaCriarComodo(gnomiot);
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
					TelaCriarComodo window = new TelaCriarComodo(gnomiot);
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
	public TelaCriarComodo(GnomIoT _gnomiot) {
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
		
		JLabel lblCriarComodo = new JLabel("Criar Cômodo");
		lblCriarComodo.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblCriarComodo.setBounds(102, 123, 130, 31);
		frame.getContentPane().add(lblCriarComodo);
		
		txtNome = new JTextField();
		txtNome.setText("");
		txtNome.setBounds(51, 204, 256, 31);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCriar.setBorder(null);
		btnCriar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nome = txtNome.getText();
				
				if(nome.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Dê um nome ao cômodo!");
				} else {
					gnomiot.criarComodo(nome);
					JOptionPane.showMessageDialog(null,"Cômodo criado");
					
					TelaComodos telaComodos = new TelaComodos(gnomiot);
					
					// fecha janela atual
					frame.dispose();
					
					// abre a proxima
					//telaComodos.main(null);
					telaComodos.start();
				}
			}
		});
		btnCriar.setBounds(125, 370, 117, 25);
		frame.getContentPane().add(btnCriar);
		
		// JButton btnVoltar = new JButton("←");
		// btnVoltar.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		TelaComodos telaComodos = new TelaComodos(gnomiot);
				
		// 		// fecha janela atual
		// 		frame.dispose();
				
		// 		// abre a proxima
		// 		//telaComodos.main(null);
		// 		telaComodos.start();
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
		// 			//telaLogin.main(null);
		// 			telaLogin.start();
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
				TelaComodos telaComodos = new TelaComodos(gnomiot);
				
				// fecha janela atual
				frame.dispose();
				
				// abre a proxima
				//telaComodos.main(null);
				telaComodos.start();
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
		
		JLabel lblBemVindo_1 = new JLabel("Bem vindo, "+ gnomiot.getUsuarioLogado().getNome() + "!");
		lblBemVindo_1.setForeground(new Color(255, 250, 250));
		lblBemVindo_1.setBounds(86, 11, 163, 19);
		lblBemVindo_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panel.add(lblBemVindo_1);
		
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
		
		
	}
}
