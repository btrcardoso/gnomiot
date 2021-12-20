package gnomIoT.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

import gnomIoT.entities.Comodo;
import gnomIoT.entities.Dispositivo;
import gnomIoT.entities.GnomIoT;
import gnomIoT.entities.Residencia;
import gnomIoT.entities.TipoDispositivo;
import java.awt.Color;
import java.awt.Cursor;


public class TelaDispositivos {
	private JFrame frmGnomiot;
	private JPanel contentPane;
	private static GnomIoT gnomiot;
	
// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	
	private double wBtn = WIDTH * 0.8;
	private double hBtn = HEIGHT * 0.05;
	private double xBtn = (WIDTH - wBtn)/2 ;
	private JLabel lblMeusDispositivos;
	private JButton btnNovoDispositivo;
	
	

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDispositivos window = new TelaDispositivos(gnomiot);
					window.frmGnomiot.setVisible(true);
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
					TelaDispositivos window = new TelaDispositivos(gnomiot);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	public TelaDispositivos(GnomIoT _gnomiot) {
		gnomiot = _gnomiot;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		
		frmGnomiot = new JFrame();
		frmGnomiot.setIconImage(new ImageIcon(this.getClass().getResource("/CasaIcone.png")).getImage());
		frmGnomiot.setTitle("GNOMIOT");
		frmGnomiot.setResizable(false);
		frmGnomiot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGnomiot.setBounds(-1, -1, WIDTH,HEIGHT);
		frmGnomiot.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmGnomiot.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// JLabel lblBemVindo = new JLabel(gnomiot.getResidenciaAtual().getNome() + " > " + gnomiot.getComodoAtual().getNome());
		// lblBemVindo.setBackground(new Color(255, 250, 250));
		// lblBemVindo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		// lblBemVindo.setBounds(33, 46, 290, 38);
		// frame.getContentPane().add(lblBemVindo, BorderLayout.CENTER);
		

		// JButton btnVoltar = new JButton("←");
		// btnVoltar.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		gnomiot.setComodoAtual(null);
				
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
				gnomiot.setComodoAtual(null);
				
				TelaComodos telaComodos = new TelaComodos(gnomiot);
				
				// fecha janela atual
				frmGnomiot.dispose();
				
				// abre a proxima
				//telaComodos.main(null);
				telaComodos.start();
			}
		});
		btnVoltar.setBounds(10, 11, 59, 26);
		frmGnomiot.getContentPane().add(btnVoltar);
		ImageIcon imgSair = new ImageIcon(this.getClass().getResource("/sair.png"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 344, 50);
		frmGnomiot.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBemVindo = new JLabel(gnomiot.getResidenciaAtual().getNome() + " > " + gnomiot.getComodoAtual().getNome());
		lblBemVindo.setBackground(new Color(255, 250, 250));
		lblBemVindo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblBemVindo.setBounds(33, 46, 290, 38);
		frmGnomiot.getContentPane().add(lblBemVindo, BorderLayout.CENTER);
		
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
					frmGnomiot.dispose();
					
					// abre a proxima
					//telaLogin.main(null);
					telaLogin.start();
				}
			}
		});
		
		
		if(gnomiot.usuarioLogadoEAdministradorOuDono()) {
			btnNovoDispositivo = new JButton("Novo dispositivo");
			btnNovoDispositivo.setBorder(null);
			btnNovoDispositivo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			btnNovoDispositivo.setFont(new Font("Century Gothic", Font.PLAIN, 11));

			btnNovoDispositivo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaAdicionarDispositivo telaAdicionarDispositivo = new TelaAdicionarDispositivo(gnomiot);
						
						// fecha janela atual
					frmGnomiot.dispose();
						
						// abre a proxima
					telaAdicionarDispositivo.start();
					//telaAdicionarDispositivo.main(null);

				}
			});
			btnNovoDispositivo.setBounds(33, 554, 290, 25);
			contentPane.add(btnNovoDispositivo);
		}
		
		
	
		ArrayList<Dispositivo> dispositivos = gnomiot.listaDeDispositivos();

		if (dispositivos.isEmpty()) {
			JLabel lblSemDispositivos = new JLabel("Nenhum dispositivo cadastrado");
			lblSemDispositivos.setHorizontalAlignment(SwingConstants.CENTER);
			// lblSemDispositivos.setBackground(new Color(255, 250, 250));

			lblSemDispositivos.setBounds(33, 300, 290, 25);
			lblSemDispositivos.setFont(new Font("Century Gothic", Font.PLAIN, 11));
			contentPane.add(lblSemDispositivos);
		}
		//ArrayList<JButton> btnsComodos = new ArrayList<JButton>();
		int espacamento = 0;
		
		for(Dispositivo dispositivo : dispositivos) {
			JButton tmp = new JButton(dispositivo.getNome());
			tmp.setBounds((int) xBtn,100 + espacamento,(int) wBtn - 42, (int) hBtn);
			tmp.setBorder(null);
			tmp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			tmp.setFont(new Font("Century Gothic", Font.PLAIN, 11));

			tmp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						gnomiot.setDispositivoAtual(dispositivo);
						// fecha janela atual
						frmGnomiot.dispose();
						if (dispositivo.getTIPO().equals(TipoDispositivo.ARCONDICIONADO)) {
							TelaArCondicionado telaDispositivo = new TelaArCondicionado(gnomiot);
							// abre a proxima
							//telaDispositivo.main(null);
							telaDispositivo.start();
						}
						else {
							TelaDispositivo telaDispositivo = new TelaDispositivo(gnomiot);
							// abre a proxima
							//telaDispositivo.main(null);
							telaDispositivo.start();

						}	
				}
			});
			
			//btnsComodos.add(tmp);
			frmGnomiot.getContentPane().add(tmp);
			
			JButton btnApagar = new JButton("");
			ImageIcon lixeira = new ImageIcon(this.getClass().getResource("/lixeira.png"));
			btnApagar.setIcon(lixeira);
			btnApagar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gnomiot.removerDispositivo(gnomiot.getComodoAtual(), dispositivo);
					tmp.setVisible(false);
					btnApagar.setVisible(false);
				}
			});
			btnApagar.setBounds((int) (xBtn + wBtn - 42), 100 + espacamento, 32, (int) hBtn);
			frmGnomiot.getContentPane().add(btnApagar);
			
			espacamento += ((int) hBtn + 10);
		}
	}

	public Rectangle getlblMeusDispositivoslBounds() {
		return lblMeusDispositivos.getBounds();
	}
	public void setlblMeusDispositivoslBounds(Rectangle bounds) {
		lblMeusDispositivos.setBounds(bounds);
	}
}
