package gnomIoT.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gnomIoT.entities.GnomIoT;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

public class TelaInicial {

	private JFrame frame;
	private int WIDTH = 360;
	private int HEIGHT = 640;
	private static GnomIoT gnomiot;

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial(gnomiot);
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
					TelaInicial window = new TelaInicial(gnomiot);
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
	public TelaInicial(GnomIoT _gnomiot) {
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
		frame.getContentPane().setBackground(UIManager.getColor("ToolBar.highlight"));
		frame.setResizable(false);
		frame.setBounds(-1, -1, WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOQueDeseja = new JLabel("O que deseja fazer?");
		lblOQueDeseja.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblOQueDeseja.setBounds(76, 178, 183, 33);
		frame.getContentPane().add(lblOQueDeseja);
		
		JButton btnEntrarEmResidencia = new JButton("Entrar em residência");
		btnEntrarEmResidencia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntrarEmResidencia.setBorder(null);
		btnEntrarEmResidencia.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnEntrarEmResidencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaResidencias telaResidencias = new TelaResidencias(gnomiot);
				
				// fecha janela atual
				frame.dispose();
				
				// abre a proxima
				//telaResidencias.main(null);
				telaResidencias.start();

			}
		});
		btnEntrarEmResidencia.setBounds(53, 281, 231, 25);
		frame.getContentPane().add(btnEntrarEmResidencia);
		
		JButton btnCriarResidencia = new JButton("Criar residência");
		btnCriarResidencia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCriarResidencia.setBorder(null);
		btnCriarResidencia.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCriarResidencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCriarResidencia telaCriarResidencia = new TelaCriarResidencia(gnomiot);
				
				// fecha janela atual
				frame.dispose();
				
				// abre a proxima
				//telaCriarResidencia.main(null);
				telaCriarResidencia.start();

			}
		});
		btnCriarResidencia.setBounds(53, 318, 231, 25);
		frame.getContentPane().add(btnCriarResidencia);
		
		JButton btnConfiguracoes = new JButton("Configurações");
		btnConfiguracoes.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnConfiguracoes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfiguracoes.setBorder(null);
		btnConfiguracoes.setBounds(53, 355, 231, 25);
		frame.getContentPane().add(btnConfiguracoes);
		
		JButton btnVoltar = new JButton("");

		ImageIcon imgVoltar = new ImageIcon(this.getClass().getResource("/voltar.png"));
		btnVoltar.setIcon(imgVoltar);

		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBackground(new Color(0, 191, 255));
		btnVoltar.setBorder(null);
		btnVoltar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnVoltar.addActionListener(new ActionListener() {
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
