package gnomIoT.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gnomIoT.entities.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.Cursor;

public class TelaComodos {

	private JFrame frame;
	private JPanel contentPane;
	private static GnomIoT gnomiot;
	
// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	
	private double wBtn = WIDTH * 0.8;
	private double hBtn = HEIGHT * 0.05;
	private double xBtn = (WIDTH - wBtn)/2 ;
	private JLabel lblMeusComodos;
	private JButton btnNovoCmodo;
	
	

	/**
	 * Launch the application.
	 */
	
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaComodos window = new TelaComodos(gnomiot);
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
					TelaComodos window = new TelaComodos(gnomiot);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	public TelaComodos(GnomIoT _gnomiot) {
		gnomiot = _gnomiot;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setIconImage(new ImageIcon(this.getClass().getResource("/CasaIcone.png")).getImage());
		frame.setTitle("GNOMIOT");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(-1, -1, WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// JLabel lblBemVindo = new JLabel(gnomiot.getResidenciaAtual().getNome());
		// lblBemVindo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		// lblBemVindo.setBounds(33, 46, 290, 38);
		// frame.getContentPane().add(lblBemVindo, BorderLayout.CENTER);
		
		// JButton btnVoltar = new JButton("←");
		// btnVoltar.setBorder(null);
		// btnVoltar.setBackground(new Color(0, 191, 255));
		// btnVoltar.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		gnomiot.setResidenciaAtual(null);
				
		// 		TelaResidencias telaResidencias = new TelaResidencias(gnomiot);
				
		// 		// fecha janela atual
		// 		frame.dispose();
				
		// 		// abre a proxima
		// 		//telaResidencias.main(null);
		// 		telaResidencias.start();

		// 	}
		// });
		// btnVoltar.setBounds(12, 12, 59, 25);
		// frame.getContentPane().add(btnVoltar);
		
		// JButton btnSair = new JButton("Sair");
		// btnSair.setForeground(new Color(255, 250, 250));
		// btnSair.setFont(new Font("Century Gothic", Font.BOLD, 11));
		// btnSair.setBackground(new Color(0, 191, 255));
		// btnSair.setBorder(null);
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
		// btnSair.setBounds(254, 12, 80, 25);
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
				gnomiot.setResidenciaAtual(null);
				
				TelaResidencias telaResidencias = new TelaResidencias(gnomiot);
				
				// fecha janela atual
				frame.dispose();
				
				// abre a proxima
				//telaResidencias.main(null);
				telaResidencias.start();
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
		
		if(gnomiot.usuarioLogadoEAdministradorOuDono()) {
			btnNovoCmodo = new JButton("Novo cômodo");
			btnNovoCmodo.setBorder(null);
			btnNovoCmodo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNovoCmodo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
			btnNovoCmodo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
                    TelaCriarComodo telaCriarComodo = new TelaCriarComodo(gnomiot);
					
					// fecha janela atual
					frame.dispose();
					
					// abre a proxima
					telaCriarComodo.start();
					//telaCriarComodo.main(null);

				}
			});
			btnNovoCmodo.setBounds(33, 554, 290, 25);
			contentPane.add(btnNovoCmodo);
		}
		
		
		// Residencia residenciaAtual = gnomiot.getResidenciaAtual();
		//ArrayList<JButton> btnsComodos = new ArrayList<JButton>();
		
		ArrayList<Comodo> comodos = gnomiot.listaDeComodos();
		int espacamento = 0;
		
		for(Comodo comodo : comodos) {
			JButton tmp = new JButton(comodo.getNome());
			tmp.setBorder(null);
			tmp.setFont(new Font("Century Gothic", Font.PLAIN, 11));
			tmp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			
			tmp.setBounds((int) xBtn,100 + espacamento,(int) wBtn, (int) hBtn);
			
			tmp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						gnomiot.setComodoAtual(comodo);
						
						TelaDispositivos telaDispositivos = new TelaDispositivos(gnomiot);
						
						// fecha janela atual
						frame.dispose();
						
						// abre a proxima
						//telaDispositivos.main(null);
						telaDispositivos.start();

				}
			});
			//btnsComodos.add(tmp);
			frame.getContentPane().add(tmp);
			espacamento += (int) hBtn + 10;
		}
	}

	public Rectangle getLblMeusComodoslBounds() {
		return lblMeusComodos.getBounds();
	}
	public void setLblMeusComodoslBounds(Rectangle bounds) {
		lblMeusComodos.setBounds(bounds);
	}
}
