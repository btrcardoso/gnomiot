package gnomIoT.view;

import java.awt.BorderLayout;
import java.awt.Component;
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

import gnomIoT.entities.*;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaDispositivo {
	private JFrame frame;
	private JPanel contentPane;
	private static GnomIoT gnomiot;
	
// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	
	private double wBtn = WIDTH * 0.8;
	private double hBtn = HEIGHT * 0.05;
	private double xBtn = (WIDTH - wBtn)/2 ;
	private JLabel lblNomeDispositivo;
	private JTextField txtTrocarNome;
	
	

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDispositivo window = new TelaDispositivo(gnomiot);
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
					TelaDispositivo window = new TelaDispositivo(gnomiot);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	public TelaDispositivo(GnomIoT _gnomiot) {
		gnomiot = _gnomiot;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		
		Dispositivo dispositivo = gnomiot.getDispositivoAtual();
		frame = new JFrame();
		frame.setIconImage(new ImageIcon(this.getClass().getResource("/CasaIcone.png")).getImage());
		frame.setTitle("GNOMIOT");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(-1, -1, WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.requestFocus();
			}
		});
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindo = new JLabel(gnomiot.getResidenciaAtual().getNome() + " > " + gnomiot.getComodoAtual().getNome());
		lblBemVindo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblBemVindo.setBounds(33, 48, 290, 25);
		frame.getContentPane().add(lblBemVindo, BorderLayout.CENTER);
		
		JLabel lblNome = new JLabel(gnomiot.getDispositivoAtual().getNome());
		
		lblNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNome.setVisible(false);
				txtTrocarNome = new JTextField();
				txtTrocarNome.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
				txtTrocarNome.setBounds(33, 85, 254, 15);
				txtTrocarNome.setColumns(10);
				txtTrocarNome.setText(lblNome.getText());
				//contentPane.add(txtTrocarNome);
				txtTrocarNome.setVisible(true);
				frame.getContentPane().add(txtTrocarNome);
				
				txtTrocarNome.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						txtTrocarNome.setVisible(false);
						gnomiot.alterarNomeDispositivo(txtTrocarNome.getText());
						lblNome.setText(dispositivo.getNome());
						lblNome.setVisible(true);
					}
				});
				
			}
		});
		lblNome.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(33, 85, 254, 15);
		contentPane.add(lblNome);
		
		JLabel lblModelo = new JLabel(gnomiot.getDispositivoAtual().getMODELO());
		lblModelo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setBounds(49, 491, 254, 15);
		contentPane.add(lblModelo);
		
		// JButton btnVoltar = new JButton("←");
		// btnVoltar.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		gnomiot.setDispositivoAtual(null);
				
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
			gnomiot.setDispositivoAtual(null);
				
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
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon( new ImageIcon(gnomiot.imagemAtual()));

		lblNewLabel.setBounds(33, 111, 275, 271);
		contentPane.add(lblNewLabel);
		
		JButton btnLigaDesliga = new JButton(estado2String(dispositivo.getEstado()));
		btnLigaDesliga.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLigaDesliga.setBorder(null);
		btnLigaDesliga.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnLigaDesliga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					dispositivo.alterarEstado();
		
					btnLigaDesliga.setText(estado2String(dispositivo.getEstado()));
					lblNewLabel.setIcon(new ImageIcon(gnomiot.imagemAtual()));
			}
		});
		btnLigaDesliga.setBounds(102, 393, 142, 23);
		contentPane.add(btnLigaDesliga);
		
		
		
		
		
	}
	public String estado2String(boolean a) {
		if(gnomiot.getDispositivoAtual().getTIPO() == TipoDispositivo.FECHADURA) {
			if (!a) return "Abrir";
			else return "Fechar";
		}
		if (!a) return "Ligar";
		else return "Desligar";
	}

	public Rectangle getlblMeusDispositivoslBounds() {
		return lblNomeDispositivo.getBounds();
	}
	public void setlblMeusDispositivoslBounds(Rectangle bounds) {
		lblNomeDispositivo.setBounds(bounds);
	}
}
