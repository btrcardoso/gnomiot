package gnomIoT.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gnomIoT.entities.GnomIoT;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;

public class TelaCriarResidencia {

	private JFrame frame;
	
	// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	private JTextField txtNomeResidencia;

	private static GnomIoT gnomiot;
	private JButton btnVoltar;
	private JButton btnSair;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCriarResidencia window = new TelaCriarResidencia(gnomiot);
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
					TelaCriarResidencia window = new TelaCriarResidencia(gnomiot);
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
	public TelaCriarResidencia(GnomIoT _gnomiot) {
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
		
		JLabel lblCriarResidncia = new JLabel("Criar Residência");
		lblCriarResidncia.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblCriarResidncia.setBounds(106, 124, 156, 25);
		frame.getContentPane().add(lblCriarResidncia);
		
		txtNomeResidencia = new JTextField();
		txtNomeResidencia.setText("");
		txtNomeResidencia.setBounds(51, 204, 256, 31);
		frame.getContentPane().add(txtNomeResidencia);
		txtNomeResidencia.setColumns(10);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCriar.setBorder(null);
		btnCriar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nomeResidencia = txtNomeResidencia.getText();
				
				if(nomeResidencia.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Dê um nome a residência!");
				} else {
					gnomiot.criarResidencia(nomeResidencia);
					JOptionPane.showMessageDialog(null,"Residência criada");
					TelaResidencias telaResidencias = new TelaResidencias(gnomiot);
					
					// fecha janela atual
					frame.dispose();
					
					// abre a proxima
					//telaResidencias.main(null);
					telaResidencias.start();

				}
			}
		});
		btnCriar.setBounds(125, 370, 117, 25);
		frame.getContentPane().add(btnCriar);
		

		JButton btnVoltar = new JButton("");

		ImageIcon imgVoltar = new ImageIcon(this.getClass().getResource("/voltar.png"));
		btnVoltar.setIcon(imgVoltar);

		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBackground(new Color(0, 191, 255));
		btnVoltar.setBorder(null);
		btnVoltar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaInicial = new TelaInicial(gnomiot);
				
				// fecha janela atual
				frame.dispose();
				
				// abre a proxima
				//telaInicial.main(null);
				telaInicial.start();
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
