package gnomIoT.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import gnomIoT.entities.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Toolkit;

public class TelaLogin {

	private JFrame frmGnomiot;
	
	// largura e altura da tela
	private int WIDTH = 360;
	private int HEIGHT = 640;
	
	// proporÃƒÂ§ÃƒÂµes das caixas de texto
	private double wTxt = WIDTH * 0.8;
	private double hTxt = HEIGHT * 0.05;
	private double xTxt = (WIDTH - wTxt)/2 ;
	private JTextField txtLogin;
	private double yTxtLogin = HEIGHT * 0.3;
	private double yTxtSenha = HEIGHT * 0.4;
	private JPasswordField pwdSenha;
	
	private static GnomIoT gnomiot = new GnomIoT();
	

	/**
	 * Launch the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin(gnomiot);
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
					TelaLogin window = new TelaLogin(gnomiot);
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
	public TelaLogin(GnomIoT _gnomiot) {
		gnomiot = _gnomiot;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGnomiot = new JFrame();
		frmGnomiot.setIconImage(new ImageIcon(this.getClass().getResource("/CasaIcone.png")).getImage());
		frmGnomiot.setTitle("GNOMIOT");
		frmGnomiot.setIconImage(new ImageIcon(this.getClass().getResource("/CasaIcone.png")).getImage());
		frmGnomiot.setTitle("GNOMIOT");
		frmGnomiot.getContentPane().setBackground(new Color(0, 191, 255));
		frmGnomiot.setResizable(false);
		frmGnomiot.setBounds(-1, -1, WIDTH,HEIGHT);
		frmGnomiot.setLocationRelativeTo(null);
		frmGnomiot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGnomiot.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblLogin.setForeground(new Color(255, 250, 250));
		lblLogin.setBounds(36, 165, 70, 25);
		frmGnomiot.getContentPane().add(lblLogin);
		
		txtLogin = new JTextField();
		//txtLogin.setText("filo@mail.com");
		txtLogin.setBounds((int) xTxt, (int) yTxtLogin, (int) wTxt, (int) hTxt);
		frmGnomiot.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblSenha.setForeground(new Color(255, 250, 250));
		lblSenha.setBounds(36, 229, 70, 25);
		frmGnomiot.getContentPane().add(lblSenha);
		
		pwdSenha = new JPasswordField();
		//pwdSenha.setText("senha");
		pwdSenha.setBounds((int) xTxt, (int) yTxtSenha, (int) wTxt, (int) hTxt);
		frmGnomiot.getContentPane().add(pwdSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		//JButton btnEntrar.setIcon()
		btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntrar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnEntrar.setForeground(new Color(255, 250, 250));
		btnEntrar.setBackground(new Color(0, 191, 255));
		btnEntrar.setBorder(null);
		frmGnomiot.getRootPane().setDefaultButton(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// AutenticaÃƒÂ§ÃƒÂ£o de usuÃƒÂ¡rio
				
				String login = txtLogin.getText();
				String senha = new String(pwdSenha.getPassword());
				
				Usuario usuario = gnomiot.autenticarUsuario(login, senha);
				
				if(usuario != null) {
					
					TelaInicial telaInicial = new TelaInicial(gnomiot);
					
					// fecha janela atual
					frmGnomiot.dispose();
					
					// abre a proxima
					//telaInicial.main(null);
					telaInicial.start();
					
				} else {
					
					JOptionPane.showMessageDialog(null,"Dados incorretos!");
					
				}
			}
		});
		btnEntrar.setBounds(207, 336, 117, 25);
		frmGnomiot.getContentPane().add(btnEntrar);
		
		JButton btnCadastrarse = new JButton("Cadastrar-se");
		btnCadastrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrarse.setBorder(null);
		btnCadastrarse.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCadastrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro telaCadastro = new TelaCadastro(gnomiot);
				
				// fecha janela atual
				frmGnomiot.dispose();
				
				// abre a proxima
				//telaCadastro.main(null);
				telaCadastro.start();
			}
		});
		btnCadastrarse.setBounds(79, 504, 199, 25);
		frmGnomiot.getContentPane().add(btnCadastrarse);
		
		JButton btnEsqueciASenha = new JButton("Esqueci a senha");
		btnEsqueciASenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEsqueciASenha.setBorder(null);
		btnEsqueciASenha.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnEsqueciASenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Tenta lembrar");
			}
		});
		btnEsqueciASenha.setBounds(79, 541, 199, 25);
		frmGnomiot.getContentPane().add(btnEsqueciASenha);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		Image imgCasa = new ImageIcon(this.getClass().getResource("/Casa.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgCasa));

		lblNewLabel.setBounds(10, 0, 338, 128);
		frmGnomiot.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		ImageIcon imgGnomio = new ImageIcon(this.getClass().getResource("/Gnomio.png"));
		lblNewLabel_1.setIcon(imgGnomio);

		lblNewLabel_1.setBounds(93, 107, 170, 33);
		frmGnomiot.getContentPane().add(lblNewLabel_1);
	}
}
