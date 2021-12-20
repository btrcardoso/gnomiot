package gnomIoT.view;

import java.awt.Color;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import gnomIoT.entities.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

public class TelaResidencias {

	private JFrame frame;
	private static GnomIoT gnomiot;
	
	// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	
	private double wBtn = WIDTH * 0.8;
	private double hBtn = HEIGHT * 0.05;
	private double xBtn = (WIDTH - wBtn)/2 ;
	
	private JButton btnVoltar;
	private JButton btnSair;
	
	

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaResidencias window = new TelaResidencias(gnomiot);
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
					TelaResidencias window = new TelaResidencias(gnomiot);
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
	public TelaResidencias(GnomIoT _gnomiot) {
		gnomiot = _gnomiot;
		initialize();
	}

	/*
	 * 
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(new ImageIcon(this.getClass().getResource("/CasaIcone.png")).getImage());
		frame.setTitle("GNOMIOT");
		frame.getContentPane().setFont(new Font("Century Gothic", Font.PLAIN, 11));
		frame.getContentPane().setBackground(new Color(255, 250, 250));
		frame.setResizable(false);
		frame.setBounds(-1, -1, WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//--------------------------------------------------------------------------------------------------
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
		

		int espacamento = 0;
		for(Residencia residencia : gnomiot.listaDeResidencias()) {
			
			JButton tmp = new JButton(residencia.getNome());
			tmp.setFont(new Font("Century Gothic", Font.PLAIN, 11));
			tmp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tmp.setBorder(null);

			tmp.setBounds((int) xBtn,100 + espacamento,(int) wBtn, (int) hBtn);
			
			tmp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						gnomiot.setResidenciaAtual(residencia);
						
						TelaComodos telaComodo = new TelaComodos(gnomiot);
						
						// fecha janela atual
						frame.dispose();
						
						// abre a proxima
						//telaComodo.main(null);
						telaComodo.start();
				}
			});
			frame.getContentPane().add(tmp);
			espacamento += (int) hBtn;
			//btnsResidencias.add(tmp);
			
		}
	}
}
